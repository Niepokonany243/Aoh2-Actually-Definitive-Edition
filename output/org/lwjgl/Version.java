/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl;

import org.lwjgl.system.APIUtil;

public final class Version {
    public static final int VERSION_MAJOR = 3;
    public static final int VERSION_MINOR = 2;
    public static final int VERSION_REVISION = 3;
    public static final BuildType BUILD_TYPE = BuildType.STABLE;
    private static final String version = String.valueOf(3) + '.' + 2 + '.' + 3 + Version.BUILD_TYPE.postfix + ' ' + APIUtil.apiGetManifestValue("Implementation-Version").orElse("SNAPSHOT");

    private Version() {
    }

    public static void main(String[] args) {
        System.out.println(Version.getVersion());
    }

    public static String getVersion() {
        return version;
    }

    public static enum BuildType {
        ALPHA("a"),
        BETA("b"),
        STABLE("");

        public final String postfix;

        private BuildType(String postfix) {
            this.postfix = postfix;
        }
    }
}

