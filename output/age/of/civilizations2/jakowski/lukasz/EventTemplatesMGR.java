/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Json;
import java.util.ArrayList;
import java.util.List;

public class EventTemplatesMGR {
    public static List<Data_Templates> eventTemplates = new ArrayList<Data_Templates>();
    public static List<Image> bgTemplates = new ArrayList<Image>();
    public static List<Image> btnTemplates = new ArrayList<Image>();

    public static void loadEventTemplates() {
        FileHandle fileList;
        String fileContent;
        Json json;
        ConfigTemplatesData data;
        Data_Templates tempData;
        int i;
        try {
            fileList = Gdx.files.internal("UI/events/templates/EventTemplates.json");
            if (fileList.exists()) {
                fileContent = fileList.readString();
                json = new Json();
                json.setElementType(ConfigTemplatesData.class, "Template", Data_Templates.class);
                data = json.fromJson(ConfigTemplatesData.class, fileContent);
                if (data.Template != null) {
                    for (Object e : data.Template) {
                        tempData = (Data_Templates)e;
                        EventTemplatesMGR.eventTemplates.add(tempData);
                        EventTemplatesMGR.bgTemplates.add(IMGManager.loadImage("UI/events/templates/" + tempData.BG_IMG, Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear, Texture.TextureWrap.ClampToEdge));
                        EventTemplatesMGR.btnTemplates.add(IMGManager.loadImage("UI/events/templates/" + tempData.BUTTON_IMG, Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear, Texture.TextureWrap.ClampToEdge));
                    }
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            for (i = 0; i < sUM.sUFS; ++i) {
                if (FileManager.IS_MAC) {
                    if (Gdx.files.external(sUM.sUF.get(i) + "UI/" + "events/" + "templates/" + "EventTemplates.json").exists()) {
                        fileList = Gdx.files.external(sUM.sUF.get(i) + "UI/" + "events/" + "templates/" + "EventTemplates.json");
                        fileContent = fileList.readString();
                        json = new Json();
                        json.setElementType(ConfigTemplatesData.class, "Template", Data_Templates.class);
                        data = json.fromJson(ConfigTemplatesData.class, fileContent);
                        if (data.Template != null) {
                            for (Object e : data.Template) {
                                tempData = (Data_Templates)e;
                                EventTemplatesMGR.eventTemplates.add(tempData);
                                EventTemplatesMGR.bgTemplates.add(IMGManager.loadImage("UI/events/templates/" + tempData.BG_IMG, Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear, Texture.TextureWrap.ClampToEdge));
                                EventTemplatesMGR.btnTemplates.add(IMGManager.loadImage("UI/events/templates/" + tempData.BUTTON_IMG, Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear, Texture.TextureWrap.ClampToEdge));
                            }
                        }
                    }
                }
                if (Gdx.files.internal(sUM.sUF.get(i) + "UI/" + "events/" + "templates/" + "EventTemplates.json").exists()) {
                    fileList = Gdx.files.internal(sUM.sUF.get(i) + "UI/" + "events/" + "templates/" + "EventTemplates.json");
                    fileContent = fileList.readString();
                    json = new Json();
                    json.setElementType(ConfigTemplatesData.class, "Template", Data_Templates.class);
                    data = json.fromJson(ConfigTemplatesData.class, fileContent);
                    if (data.Template != null) {
                        for (Object e : data.Template) {
                            tempData = (Data_Templates)e;
                            EventTemplatesMGR.eventTemplates.add(tempData);
                            EventTemplatesMGR.bgTemplates.add(IMGManager.loadImage("UI/events/templates/" + tempData.BG_IMG, Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear, Texture.TextureWrap.ClampToEdge));
                            EventTemplatesMGR.btnTemplates.add(IMGManager.loadImage("UI/events/templates/" + tempData.BUTTON_IMG, Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear, Texture.TextureWrap.ClampToEdge));
                        }
                    }
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            for (i = 0; i < sUM.sUII.size(); ++i) {
                if (Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + "UI/" + "events/" + "templates/" + "EventTemplates.json").exists()) {
                    fileList = Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + "UI/" + "events/" + "templates/" + "EventTemplates.json");
                    fileContent = fileList.readString();
                    json = new Json();
                    json.setElementType(ConfigTemplatesData.class, "Template", Data_Templates.class);
                    data = json.fromJson(ConfigTemplatesData.class, fileContent);
                    if (data.Template != null) {
                        for (Object e : data.Template) {
                            tempData = (Data_Templates)e;
                            EventTemplatesMGR.eventTemplates.add(tempData);
                            EventTemplatesMGR.bgTemplates.add(IMGManager.loadImage("UI/events/templates/" + tempData.BG_IMG, Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear, Texture.TextureWrap.ClampToEdge));
                            EventTemplatesMGR.btnTemplates.add(IMGManager.loadImage("UI/events/templates/" + tempData.BUTTON_IMG, Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear, Texture.TextureWrap.ClampToEdge));
                        }
                    }
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static class ConfigTemplatesData {
        public String Age_of_History_Definitive_Edition;
        public ArrayList Template;
    }

    public static class Data_Templates {
        public String TAG;
        public String BG_IMG;
        public String DEFAULT_IMG;
        public int imgPosX = 0;
        public int imgPosY = 0;
        public int imgWidth = 10;
        public int imgHeight = 10;
        public int titlePosX = 0;
        public int titlePosY = 0;
        public int titleWidth = 10;
        public int titleHeight = 10;
        public int[] titleColor;
        public int descPosX = 0;
        public int descPosY = 0;
        public int descWidth = 10;
        public int[] descColor;
        public String BUTTON_IMG;
        public int btnPosX = 0;
        public int btnPosY = 0;
        public int btnWidth = 0;
        public int btnHeight = 0;
        public boolean nextButtonBelow = true;
        public int[] btnColor;
    }
}
