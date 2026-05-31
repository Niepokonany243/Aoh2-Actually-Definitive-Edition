/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.scenes.scene2d.utils.Selection;
import com.badlogic.gdx.scenes.scene2d.utils.UIUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Null;

public class Tree<N extends Node, V>
extends WidgetGroup {
    private static final Vector2 tmp = new Vector2();
    TreeStyle style;
    final Array<N> rootNodes = new Array();
    final Selection<N> selection = new Selection<N>(){

        @Override
        protected void changed() {
            switch (this.size()) {
                case 0: {
                    Tree.this.rangeStart = null;
                    break;
                }
                case 1: {
                    Tree.this.rangeStart = (Node)this.first();
                }
            }
        }
    };
    float ySpacing = 4.0f;
    float iconSpacingLeft = 2.0f;
    float iconSpacingRight = 2.0f;
    float paddingLeft;
    float paddingRight;
    float indentSpacing;
    private float prefWidth;
    private float prefHeight;
    private boolean sizeInvalid = true;
    private N foundNode;
    private N overNode;
    N rangeStart;
    private ClickListener clickListener;

    public Tree(Skin skin) {
        this(skin.get(TreeStyle.class));
    }

    public Tree(Skin skin, String styleName) {
        this(skin.get(styleName, TreeStyle.class));
    }

    public Tree(TreeStyle style) {
        this.selection.setActor(this);
        this.selection.setMultiple(true);
        this.setStyle(style);
        this.initialize();
    }

    private void initialize() {
        this.clickListener = new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                Object node = Tree.this.getNodeAt(y);
                if (node == null) {
                    return;
                }
                if (node != Tree.this.getNodeAt(this.getTouchDownY())) {
                    return;
                }
                if (Tree.this.selection.getMultiple() && Tree.this.selection.notEmpty() && UIUtils.shift()) {
                    float end;
                    float start;
                    if (Tree.this.rangeStart == null) {
                        Tree.this.rangeStart = node;
                    }
                    Object rangeStart = Tree.this.rangeStart;
                    if (!UIUtils.ctrl()) {
                        Tree.this.selection.clear();
                    }
                    if ((start = ((Actor)((Node)rangeStart).actor).getY()) > (end = ((Actor)((Node)node).actor).getY())) {
                        Tree.this.selectNodes(Tree.this.rootNodes, end, start);
                    } else {
                        Tree.this.selectNodes(Tree.this.rootNodes, start, end);
                        Tree.this.selection.items().orderedItems().reverse();
                    }
                    Tree.this.selection.fireChangeEvent();
                    Tree.this.rangeStart = rangeStart;
                    return;
                }
                if (!(((Node)node).children.size <= 0 || Tree.this.selection.getMultiple() && UIUtils.ctrl())) {
                    float rowX = ((Actor)((Node)node).actor).getX();
                    if (((Node)node).icon != null) {
                        rowX -= Tree.this.iconSpacingRight + ((Node)node).icon.getMinWidth();
                    }
                    if (x < rowX) {
                        ((Node)node).setExpanded(!((Node)node).expanded);
                        return;
                    }
                }
                if (!((Node)node).isSelectable()) {
                    return;
                }
                Tree.this.selection.choose(node);
                if (!Tree.this.selection.isEmpty()) {
                    Tree.this.rangeStart = node;
                }
            }

            @Override
            public boolean mouseMoved(InputEvent event, float x, float y) {
                Tree.this.setOverNode(Tree.this.getNodeAt(y));
                return false;
            }

            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                super.enter(event, x, y, pointer, fromActor);
                Tree.this.setOverNode(Tree.this.getNodeAt(y));
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, @Null Actor toActor) {
                super.exit(event, x, y, pointer, toActor);
                if (toActor == null || !toActor.isDescendantOf(Tree.this)) {
                    Tree.this.setOverNode(null);
                }
            }
        };
        this.addListener(this.clickListener);
    }

    public void setStyle(TreeStyle style) {
        this.style = style;
        if (this.indentSpacing == 0.0f) {
            this.indentSpacing = this.plusMinusWidth();
        }
    }

    public void add(N node) {
        this.insert(this.rootNodes.size, node);
    }

    public void insert(int index, N node) {
        int actorIndex;
        if (((Node)node).parent != null) {
            ((Node)((Node)node).parent).remove(node);
            ((Node)node).parent = null;
        } else {
            int existingIndex = this.rootNodes.indexOf(node, true);
            if (existingIndex != -1) {
                if (existingIndex == index) {
                    return;
                }
                if (existingIndex < index) {
                    --index;
                }
                this.rootNodes.removeIndex(existingIndex);
                int actorIndex2 = ((Actor)((Node)node).actor).getZIndex();
                if (actorIndex2 != -1) {
                    ((Node)node).removeFromTree(this, actorIndex2);
                }
            }
        }
        this.rootNodes.insert(index, node);
        if (index == 0) {
            actorIndex = 0;
        } else if (index < this.rootNodes.size - 1) {
            actorIndex = ((Actor)((Node)this.rootNodes.get((int)(index + 1))).actor).getZIndex();
        } else {
            Node before = (Node)this.rootNodes.get(index - 1);
            actorIndex = ((Actor)before.actor).getZIndex() + before.countActors();
        }
        ((Node)node).addToTree(this, actorIndex);
    }

    public void remove(N node) {
        if (((Node)node).parent != null) {
            ((Node)((Node)node).parent).remove(node);
            return;
        }
        if (!this.rootNodes.removeValue(node, true)) {
            return;
        }
        int actorIndex = ((Actor)((Node)node).actor).getZIndex();
        if (actorIndex != -1) {
            ((Node)node).removeFromTree(this, actorIndex);
        }
    }

    @Override
    public void clearChildren(boolean unfocus) {
        super.clearChildren(unfocus);
        this.setOverNode(null);
        this.rootNodes.clear();
        this.selection.clear();
    }

    @Override
    public void invalidate() {
        super.invalidate();
        this.sizeInvalid = true;
    }

    private float plusMinusWidth() {
        float width = Math.max(this.style.plus.getMinWidth(), this.style.minus.getMinWidth());
        if (this.style.plusOver != null) {
            width = Math.max(width, this.style.plusOver.getMinWidth());
        }
        if (this.style.minusOver != null) {
            width = Math.max(width, this.style.minusOver.getMinWidth());
        }
        return width;
    }

    private void computeSize() {
        this.sizeInvalid = false;
        this.prefWidth = this.plusMinusWidth();
        this.prefHeight = 0.0f;
        this.computeSize(this.rootNodes, 0.0f, this.prefWidth);
        this.prefWidth += this.paddingLeft + this.paddingRight;
    }

    private void computeSize(Array<N> nodes, float indent, float plusMinusWidth) {
        float ySpacing = this.ySpacing;
        float spacing = this.iconSpacingLeft + this.iconSpacingRight;
        int n = nodes.size;
        for (int i = 0; i < n; ++i) {
            Node node = (Node)nodes.get(i);
            float rowWidth = indent + plusMinusWidth;
            Object actor = node.actor;
            if (actor instanceof Layout) {
                Layout layout = (Layout)actor;
                rowWidth += layout.getPrefWidth();
                node.height = layout.getPrefHeight();
            } else {
                rowWidth += ((Actor)actor).getWidth();
                node.height = ((Actor)actor).getHeight();
            }
            if (node.icon != null) {
                rowWidth += spacing + node.icon.getMinWidth();
                node.height = Math.max(node.height, node.icon.getMinHeight());
            }
            this.prefWidth = Math.max(this.prefWidth, rowWidth);
            this.prefHeight += node.height + ySpacing;
            if (!node.expanded) continue;
            this.computeSize(node.children, indent + this.indentSpacing, plusMinusWidth);
        }
    }

    @Override
    public void layout() {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        this.layout(this.rootNodes, this.paddingLeft, this.getHeight() - this.ySpacing / 2.0f, this.plusMinusWidth());
    }

    private float layout(Array<N> nodes, float indent, float y, float plusMinusWidth) {
        float ySpacing = this.ySpacing;
        float iconSpacingLeft = this.iconSpacingLeft;
        float spacing = iconSpacingLeft + this.iconSpacingRight;
        int n = nodes.size;
        for (int i = 0; i < n; ++i) {
            Node node = (Node)nodes.get(i);
            float x = indent + plusMinusWidth;
            x = node.icon != null ? (x += spacing + node.icon.getMinWidth()) : (x += iconSpacingLeft);
            if (node.actor instanceof Layout) {
                ((Layout)node.actor).pack();
            }
            ((Actor)node.actor).setPosition(x, y -= node.getHeight());
            y -= ySpacing;
            if (!node.expanded) continue;
            y = this.layout(node.children, indent + this.indentSpacing, y, plusMinusWidth);
        }
        return y;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        this.drawBackground(batch, parentAlpha);
        Color color = this.getColor();
        float a = color.a * parentAlpha;
        batch.setColor(color.r, color.g, color.b, a);
        this.draw(batch, color.r, color.g, color.b, a, this.rootNodes, this.paddingLeft, this.plusMinusWidth());
        super.draw(batch, parentAlpha);
    }

    protected void drawBackground(Batch batch, float parentAlpha) {
        if (this.style.background != null) {
            Color color = this.getColor();
            batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
            this.style.background.draw(batch, this.getX(), this.getY(), this.getWidth(), this.getHeight());
        }
    }

    private void draw(Batch batch, float r, float g, float b, float a, Array<N> nodes, float indent, float plusMinusWidth) {
        Rectangle cullingArea = this.getCullingArea();
        float cullBottom = 0.0f;
        float cullTop = 0.0f;
        if (cullingArea != null) {
            cullBottom = cullingArea.y;
            cullTop = cullBottom + cullingArea.height;
        }
        TreeStyle style = this.style;
        float x = this.getX();
        float y = this.getY();
        float expandX = x + indent;
        float iconX = expandX + plusMinusWidth + this.iconSpacingLeft;
        int n = nodes.size;
        for (int i = 0; i < n; ++i) {
            Node node = (Node)nodes.get(i);
            Object actor = node.actor;
            float actorY = ((Actor)actor).getY();
            float height = node.height;
            if (cullingArea == null || actorY + height >= cullBottom && actorY <= cullTop) {
                if (this.selection.contains(node) && style.selection != null) {
                    this.drawSelection(node, style.selection, batch, x, y + actorY - this.ySpacing / 2.0f, this.getWidth(), height + this.ySpacing);
                } else if (node == this.overNode && style.over != null) {
                    this.drawOver(node, style.over, batch, x, y + actorY - this.ySpacing / 2.0f, this.getWidth(), height + this.ySpacing);
                }
                if (node.icon != null) {
                    float iconY = y + actorY + (float)Math.round((height - node.icon.getMinHeight()) / 2.0f);
                    Color actorColor = ((Actor)actor).getColor();
                    batch.setColor(actorColor.r, actorColor.g, actorColor.b, actorColor.a * a);
                    this.drawIcon(node, node.icon, batch, iconX, iconY);
                    batch.setColor(r, g, b, a);
                }
                if (node.children.size > 0) {
                    Drawable expandIcon = this.getExpandIcon(node, iconX);
                    float iconY = y + actorY + (float)Math.round((height - expandIcon.getMinHeight()) / 2.0f);
                    this.drawExpandIcon(node, expandIcon, batch, expandX, iconY);
                }
            } else if (actorY < cullBottom) {
                return;
            }
            if (!node.expanded || node.children.size <= 0) continue;
            this.draw(batch, r, g, b, a, node.children, indent + this.indentSpacing, plusMinusWidth);
        }
    }

    protected void drawSelection(N node, Drawable selection, Batch batch, float x, float y, float width, float height) {
        selection.draw(batch, x, y, width, height);
    }

    protected void drawOver(N node, Drawable over, Batch batch, float x, float y, float width, float height) {
        over.draw(batch, x, y, width, height);
    }

    protected void drawExpandIcon(N node, Drawable expandIcon, Batch batch, float x, float y) {
        expandIcon.draw(batch, x, y, expandIcon.getMinWidth(), expandIcon.getMinHeight());
    }

    protected void drawIcon(N node, Drawable icon, Batch batch, float x, float y) {
        icon.draw(batch, x, y, icon.getMinWidth(), icon.getMinHeight());
    }

    protected Drawable getExpandIcon(N node, float iconX) {
        float mouseX;
        boolean over = false;
        if (node == this.overNode && Gdx.app.getType() == Application.ApplicationType.Desktop && (!this.selection.getMultiple() || !UIUtils.ctrl() && !UIUtils.shift()) && (mouseX = this.screenToLocalCoordinates((Vector2)Tree.tmp.set((float)((float)Gdx.input.getX()), (float)0.0f)).x) >= 0.0f && mouseX < iconX) {
            over = true;
        }
        if (over) {
            Drawable icon;
            Drawable drawable = icon = ((Node)node).expanded ? this.style.minusOver : this.style.plusOver;
            if (icon != null) {
                return icon;
            }
        }
        return ((Node)node).expanded ? this.style.minus : this.style.plus;
    }

    @Null
    public N getNodeAt(float y) {
        this.foundNode = null;
        this.getNodeAt(this.rootNodes, y, this.getHeight());
        return this.foundNode;
    }

    private float getNodeAt(Array<N> nodes, float y, float rowY) {
        int n = nodes.size;
        for (int i = 0; i < n; ++i) {
            Node node = (Node)nodes.get(i);
            float height = node.height;
            if (y >= (rowY -= node.getHeight() - height) - height - this.ySpacing && y < rowY) {
                this.foundNode = node;
                return -1.0f;
            }
            rowY -= height + this.ySpacing;
            if (!node.expanded || (rowY = this.getNodeAt(node.children, y, rowY)) != -1.0f) continue;
            return -1.0f;
        }
        return rowY;
    }

    void selectNodes(Array<N> nodes, float low, float high) {
        int n = nodes.size;
        for (int i = 0; i < n; ++i) {
            Node node = (Node)nodes.get(i);
            if (((Actor)node.actor).getY() < low) break;
            if (!node.isSelectable()) continue;
            if (((Actor)node.actor).getY() <= high) {
                this.selection.add(node);
            }
            if (!node.expanded) continue;
            this.selectNodes(node.children, low, high);
        }
    }

    public Selection<N> getSelection() {
        return this.selection;
    }

    @Null
    public N getSelectedNode() {
        return (N)((Node)this.selection.first());
    }

    @Null
    public V getSelectedValue() {
        Node node = (Node)this.selection.first();
        return node == null ? null : (V)node.getValue();
    }

    public TreeStyle getStyle() {
        return this.style;
    }

    public Array<N> getRootNodes() {
        return this.rootNodes;
    }

    @Deprecated
    public Array<N> getNodes() {
        return this.rootNodes;
    }

    public void updateRootNodes() {
        int i;
        int n = this.rootNodes.size;
        for (i = 0; i < n; ++i) {
            Node node = (Node)this.rootNodes.get(i);
            int actorIndex = ((Actor)node.actor).getZIndex();
            if (actorIndex == -1) continue;
            node.removeFromTree(this, actorIndex);
        }
        n = this.rootNodes.size;
        int actorIndex = 0;
        for (i = 0; i < n; ++i) {
            actorIndex += ((Node)this.rootNodes.get(i)).addToTree(this, actorIndex);
        }
    }

    @Null
    public N getOverNode() {
        return this.overNode;
    }

    @Null
    public V getOverValue() {
        if (this.overNode == null) {
            return null;
        }
        return ((Node)this.overNode).getValue();
    }

    public void setOverNode(@Null N overNode) {
        this.overNode = overNode;
    }

    public void setPadding(float padding) {
        this.paddingLeft = padding;
        this.paddingRight = padding;
    }

    public void setPadding(float left, float right) {
        this.paddingLeft = left;
        this.paddingRight = right;
    }

    public void setIndentSpacing(float indentSpacing) {
        this.indentSpacing = indentSpacing;
    }

    public float getIndentSpacing() {
        return this.indentSpacing;
    }

    public void setYSpacing(float ySpacing) {
        this.ySpacing = ySpacing;
    }

    public float getYSpacing() {
        return this.ySpacing;
    }

    public void setIconSpacing(float left, float right) {
        this.iconSpacingLeft = left;
        this.iconSpacingRight = right;
    }

    @Override
    public float getPrefWidth() {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.prefWidth;
    }

    @Override
    public float getPrefHeight() {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.prefHeight;
    }

    public void findExpandedValues(Array<V> values) {
        Tree.findExpandedValues(this.rootNodes, values);
    }

    public void restoreExpandedValues(Array<V> values) {
        int n = values.size;
        for (int i = 0; i < n; ++i) {
            N node = this.findNode(values.get(i));
            if (node == null) continue;
            ((Node)node).setExpanded(true);
            ((Node)node).expandTo();
        }
    }

    static boolean findExpandedValues(Array<? extends Node> nodes, Array values) {
        boolean expanded = false;
        int n = nodes.size;
        for (int i = 0; i < n; ++i) {
            Node node = nodes.get(i);
            if (!node.expanded || Tree.findExpandedValues(node.children, values)) continue;
            values.add(node.value);
        }
        return expanded;
    }

    @Null
    public N findNode(V value) {
        if (value == null) {
            throw new IllegalArgumentException("value cannot be null.");
        }
        return (N)Tree.findNode(this.rootNodes, value);
    }

    @Null
    static Node findNode(Array<? extends Node> nodes, Object value) {
        Node node;
        int i;
        int n = nodes.size;
        for (i = 0; i < n; ++i) {
            node = nodes.get(i);
            if (!value.equals(node.value)) continue;
            return node;
        }
        n = nodes.size;
        for (i = 0; i < n; ++i) {
            node = nodes.get(i);
            Node found = Tree.findNode(node.children, value);
            if (found == null) continue;
            return found;
        }
        return null;
    }

    public void collapseAll() {
        Tree.collapseAll(this.rootNodes);
    }

    static void collapseAll(Array<? extends Node> nodes) {
        int n = nodes.size;
        for (int i = 0; i < n; ++i) {
            Node node = nodes.get(i);
            node.setExpanded(false);
            Tree.collapseAll(node.children);
        }
    }

    public void expandAll() {
        Tree.expandAll(this.rootNodes);
    }

    static void expandAll(Array<? extends Node> nodes) {
        int n = nodes.size;
        for (int i = 0; i < n; ++i) {
            nodes.get(i).expandAll();
        }
    }

    public ClickListener getClickListener() {
        return this.clickListener;
    }

    public static class TreeStyle {
        public Drawable plus;
        public Drawable minus;
        @Null
        public Drawable plusOver;
        @Null
        public Drawable minusOver;
        @Null
        public Drawable over;
        @Null
        public Drawable selection;
        @Null
        public Drawable background;

        public TreeStyle() {
        }

        public TreeStyle(Drawable plus, Drawable minus, @Null Drawable selection) {
            this.plus = plus;
            this.minus = minus;
            this.selection = selection;
        }

        public TreeStyle(TreeStyle style) {
            this.plus = style.plus;
            this.minus = style.minus;
            this.plusOver = style.plusOver;
            this.minusOver = style.minusOver;
            this.over = style.over;
            this.selection = style.selection;
            this.background = style.background;
        }
    }

    public static abstract class Node<N extends Node, V, A extends Actor> {
        A actor;
        N parent;
        final Array<N> children = new Array(0);
        boolean selectable = true;
        boolean expanded;
        Drawable icon;
        float height;
        V value;

        public Node(A actor) {
            if (actor == null) {
                throw new IllegalArgumentException("actor cannot be null.");
            }
            this.actor = actor;
        }

        public Node() {
        }

        public void setExpanded(boolean expanded) {
            if (expanded == this.expanded) {
                return;
            }
            this.expanded = expanded;
            if (this.children.size == 0) {
                return;
            }
            Tree<N, V> tree = this.getTree();
            if (tree == null) {
                return;
            }
            T[] children = this.children.items;
            int actorIndex = ((Actor)this.actor).getZIndex() + 1;
            if (expanded) {
                int n = this.children.size;
                for (int i = 0; i < n; ++i) {
                    actorIndex += ((Node)children[i]).addToTree(tree, actorIndex);
                }
            } else {
                int n = this.children.size;
                for (int i = 0; i < n; ++i) {
                    ((Node)children[i]).removeFromTree(tree, actorIndex);
                }
            }
        }

        protected int addToTree(Tree<N, V> tree, int actorIndex) {
            tree.addActorAt(actorIndex, (Actor)this.actor);
            if (!this.expanded) {
                return 1;
            }
            int childIndex = actorIndex + 1;
            T[] children = this.children.items;
            int n = this.children.size;
            for (int i = 0; i < n; ++i) {
                childIndex += ((Node)children[i]).addToTree(tree, childIndex);
            }
            return childIndex - actorIndex;
        }

        protected void removeFromTree(Tree<N, V> tree, int actorIndex) {
            Actor removeActorAt = tree.removeActorAt(actorIndex, true);
            if (!this.expanded) {
                return;
            }
            T[] children = this.children.items;
            int n = this.children.size;
            for (int i = 0; i < n; ++i) {
                ((Node)children[i]).removeFromTree(tree, actorIndex);
            }
        }

        public void add(N node) {
            this.insert(this.children.size, node);
        }

        public void addAll(Array<N> nodes) {
            int n = nodes.size;
            for (int i = 0; i < n; ++i) {
                this.insert(this.children.size, (Node)nodes.get(i));
            }
        }

        public void insert(int childIndex, N node) {
            ((Node)node).parent = this;
            this.children.insert(childIndex, node);
            if (!this.expanded) {
                return;
            }
            Tree<N, V> tree = this.getTree();
            if (tree != null) {
                int actorIndex;
                if (childIndex == 0) {
                    actorIndex = ((Actor)this.actor).getZIndex() + 1;
                } else if (childIndex < this.children.size - 1) {
                    actorIndex = ((Actor)((Node)this.children.get((int)(childIndex + 1))).actor).getZIndex();
                } else {
                    Node before = (Node)this.children.get(childIndex - 1);
                    actorIndex = ((Actor)before.actor).getZIndex() + before.countActors();
                }
                ((Node)node).addToTree(tree, actorIndex);
            }
        }

        int countActors() {
            if (!this.expanded) {
                return 1;
            }
            int count = 1;
            T[] children = this.children.items;
            int n = this.children.size;
            for (int i = 0; i < n; ++i) {
                count += ((Node)children[i]).countActors();
            }
            return count;
        }

        public void remove() {
            Tree<Node, V> tree = this.getTree();
            if (tree != null) {
                tree.remove(this);
            } else if (this.parent != null) {
                this.parent.remove((Node)this);
            }
        }

        public void remove(N node) {
            if (!this.children.removeValue(node, true)) {
                return;
            }
            if (!this.expanded) {
                return;
            }
            Tree<N, V> tree = this.getTree();
            if (tree != null) {
                ((Node)node).removeFromTree(tree, ((Actor)((Node)node).actor).getZIndex());
            }
        }

        public void clearChildren() {
            Tree<N, V> tree;
            if (this.expanded && (tree = this.getTree()) != null) {
                int actorIndex = ((Actor)this.actor).getZIndex() + 1;
                T[] children = this.children.items;
                int n = this.children.size;
                for (int i = 0; i < n; ++i) {
                    ((Node)children[i]).removeFromTree(tree, actorIndex);
                }
            }
            this.children.clear();
        }

        @Null
        public Tree<N, V> getTree() {
            Group parent = ((Actor)this.actor).getParent();
            if (parent instanceof Tree) {
                return (Tree)parent;
            }
            return null;
        }

        public void setActor(A newActor) {
            Tree<N, V> tree;
            if (this.actor != null && (tree = this.getTree()) != null) {
                int index = ((Actor)this.actor).getZIndex();
                tree.removeActorAt(index, true);
                tree.addActorAt(index, (Actor)newActor);
            }
            this.actor = newActor;
        }

        public A getActor() {
            return this.actor;
        }

        public boolean isExpanded() {
            return this.expanded;
        }

        public Array<N> getChildren() {
            return this.children;
        }

        public boolean hasChildren() {
            return this.children.size > 0;
        }

        public void updateChildren() {
            int i;
            if (!this.expanded) {
                return;
            }
            Tree<N, V> tree = this.getTree();
            if (tree == null) {
                return;
            }
            T[] children = this.children.items;
            int n = this.children.size;
            int actorIndex = ((Actor)this.actor).getZIndex() + 1;
            for (i = 0; i < n; ++i) {
                ((Node)children[i]).removeFromTree(tree, actorIndex);
            }
            for (i = 0; i < n; ++i) {
                actorIndex += ((Node)children[i]).addToTree(tree, actorIndex);
            }
        }

        @Null
        public N getParent() {
            return this.parent;
        }

        public void setIcon(@Null Drawable icon) {
            this.icon = icon;
        }

        @Null
        public V getValue() {
            return this.value;
        }

        public void setValue(@Null V value) {
            this.value = value;
        }

        @Null
        public Drawable getIcon() {
            return this.icon;
        }

        public int getLevel() {
            int level = 0;
            Node<N, V, A> current = this;
            do {
                ++level;
            } while ((current = current.getParent()) != null);
            return level;
        }

        @Null
        public N findNode(V value) {
            if (value == null) {
                throw new IllegalArgumentException("value cannot be null.");
            }
            if (value.equals(this.value)) {
                return (N)this;
            }
            return (N)Tree.findNode(this.children, value);
        }

        public void collapseAll() {
            this.setExpanded(false);
            Tree.collapseAll(this.children);
        }

        public void expandAll() {
            this.setExpanded(true);
            if (this.children.size > 0) {
                Tree.expandAll(this.children);
            }
        }

        public void expandTo() {
            N node = this.parent;
            while (node != null) {
                ((Node)node).setExpanded(true);
                node = ((Node)node).parent;
            }
        }

        public boolean isSelectable() {
            return this.selectable;
        }

        public void setSelectable(boolean selectable) {
            this.selectable = selectable;
        }

        public void findExpandedValues(Array<V> values) {
            if (this.expanded && !Tree.findExpandedValues(this.children, values)) {
                values.add(this.value);
            }
        }

        public void restoreExpandedValues(Array<V> values) {
            int n = values.size;
            for (int i = 0; i < n; ++i) {
                N node = this.findNode(values.get(i));
                if (node == null) continue;
                ((Node)node).setExpanded(true);
                ((Node)node).expandTo();
            }
        }

        public float getHeight() {
            return this.height;
        }

        public boolean isAscendantOf(N node) {
            if (node == null) {
                throw new IllegalArgumentException("node cannot be null.");
            }
            N current = node;
            do {
                if (current != this) continue;
                return true;
            } while ((current = ((Node)current).parent) != null);
            return false;
        }

        public boolean isDescendantOf(N node) {
            if (node == null) {
                throw new IllegalArgumentException("node cannot be null.");
            }
            Node<N, V, A> parent = this;
            do {
                if (parent != node) continue;
                return true;
            } while ((parent = parent.parent) != null);
            return false;
        }
    }
}

