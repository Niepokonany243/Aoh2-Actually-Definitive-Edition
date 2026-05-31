/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menus.Editors.GameCivs.Edit.Menu_Workshop_Load;
import age.of.civilizations2.jakowski.lukasz.SteamGame;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.codedisaster.steamworks.SteamAPI;
import com.codedisaster.steamworks.SteamAPICall;
import com.codedisaster.steamworks.SteamException;
import com.codedisaster.steamworks.SteamFriends;
import com.codedisaster.steamworks.SteamFriendsCallback;
import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamLeaderboardEntriesHandle;
import com.codedisaster.steamworks.SteamLeaderboardHandle;
import com.codedisaster.steamworks.SteamPublishedFileID;
import com.codedisaster.steamworks.SteamRemoteStorage;
import com.codedisaster.steamworks.SteamRemoteStorageCallback;
import com.codedisaster.steamworks.SteamResult;
import com.codedisaster.steamworks.SteamUGC;
import com.codedisaster.steamworks.SteamUGCCallback;
import com.codedisaster.steamworks.SteamUGCDetails;
import com.codedisaster.steamworks.SteamUGCHandle;
import com.codedisaster.steamworks.SteamUGCQuery;
import com.codedisaster.steamworks.SteamUserStats;
import com.codedisaster.steamworks.SteamUserStatsCallback;
import com.codedisaster.steamworks.SteamUtils;
import com.codedisaster.steamworks.SteamUtilsCallback;

public class Platform {
    private static final boolean INIT_STEAM = true;
    private static boolean initialized = false;

    public static void init() {
        if (initialized) {
            return;
        }
        if (!CFG.getIsDesktop()) {
            return;
        }
        if (sUM.sU == null) {
            try {
                SteamAPI.loadLibraries();
                if (SteamAPI.init() || SteamAPI.restartAppIfNecessary(3381680)) {
                    sUM.sUInited = true;
                }
            }
            catch (SteamException ex) {
                ex.printStackTrace();
            }
            sUM.sUR = new SteamRemoteStorage(new SteamRemoteStorageCallback(){

                @Override
                public void onFileShareResult(SteamUGCHandle steamUGCHandle, String s, SteamResult steamResult) {
                }

                @Override
                public void onDownloadUGCResult(SteamUGCHandle steamUGCHandle, SteamResult steamResult) {
                }

                @Override
                public void onPublishFileResult(SteamPublishedFileID steamPublishedFileID, boolean b, SteamResult steamResult) {
                }

                @Override
                public void onUpdatePublishedFileResult(SteamPublishedFileID steamPublishedFileID, boolean b, SteamResult steamResult) {
                }

                @Override
                public void onPublishedFileSubscribed(SteamPublishedFileID steamPublishedFileID, int i) {
                }

                @Override
                public void onPublishedFileUnsubscribed(SteamPublishedFileID steamPublishedFileID, int i) {
                }

                @Override
                public void onPublishedFileDeleted(SteamPublishedFileID steamPublishedFileID, int i) {
                }

                @Override
                public void onFileWriteAsyncComplete(SteamResult steamResult) {
                }

                @Override
                public void onFileReadAsyncComplete(SteamAPICall steamAPICall, SteamResult steamResult, int i, int i1) {
                }
            });
            sUM.sUC = new SteamUGCCallback(){

                @Override
                public void onUGCQueryCompleted(SteamUGCQuery steamUGCQuery, int i, int i1, boolean b, SteamResult steamResult) {
                }

                @Override
                public void onSubscribeItem(SteamPublishedFileID steamPublishedFileID, SteamResult steamResult) {
                }

                @Override
                public void onUnsubscribeItem(SteamPublishedFileID steamPublishedFileID, SteamResult steamResult) {
                }

                @Override
                public void onRequestUGCDetails(SteamUGCDetails steamUGCDetails, SteamResult steamResult) {
                }

                @Override
                public void onCreateItem(SteamPublishedFileID steamPublishedFileID, boolean b, SteamResult steamResult) {
                    sUM.sUCP = steamPublishedFileID;
                    if (steamResult == SteamResult.OK) {
                        CFG.toastM.addM(CFG.lang.get("UploadedSuccessfully"), CFG.COLOR_POSITIVE);
                    } else {
                        CFG.toastM.addM("Create" + CFG.lang.get("Error") + ": " + steamResult.name(), CFG.COLOR_NEGATIVE_1);
                    }
                    sUM.DONE = true;
                }

                @Override
                public void onSubmitItemUpdate(SteamPublishedFileID steamPublishedFileID, boolean b, SteamResult steamResult) {
                    if (steamResult == SteamResult.OK) {
                        CFG.toastM.addM(CFG.lang.get("UploadedSuccessfully"), CFG.COLOR_POSITIVE);
                    } else {
                        CFG.toastM.addM("Update" + CFG.lang.get("Error") + ": " + steamResult.name(), CFG.COLOR_NEGATIVE_1);
                    }
                    sUM.DONE = true;
                    Menu_Workshop_Load.uploaded = true;
                }

                @Override
                public void onDownloadItemResult(int i, SteamPublishedFileID steamPublishedFileID, SteamResult steamResult) {
                }

                @Override
                public void onUserFavoriteItemsListChanged(SteamPublishedFileID steamPublishedFileID, boolean b, SteamResult steamResult) {
                }

                @Override
                public void onSetUserItemVote(SteamPublishedFileID steamPublishedFileID, boolean b, SteamResult steamResult) {
                }

                @Override
                public void onGetUserItemVote(SteamPublishedFileID steamPublishedFileID, boolean b, boolean b1, boolean b2, SteamResult steamResult) {
                }

                @Override
                public void onStartPlaytimeTracking(SteamResult steamResult) {
                }

                @Override
                public void onStopPlaytimeTracking(SteamResult steamResult) {
                }

                @Override
                public void onStopPlaytimeTrackingForAllItems(SteamResult steamResult) {
                }

                @Override
                public void onDeleteItem(SteamPublishedFileID steamPublishedFileID, SteamResult steamResult) {
                }
            };
            sUM.uSG = new SteamGame();
            sUM.sU = new SteamUGC(sUM.sUC);
            sUM.sUT = new SteamUtils(new SteamUtilsCallback(){

                @Override
                public void onSteamShutdown() {
                    SteamAPI.shutdown();
                }
            });
            sUM.sUI = new SteamUserStats(new SteamUserStatsCallback(){

                @Override
                public void onUserStatsReceived(long gameId, SteamID steamIDUser, SteamResult result) {
                }

                @Override
                public void onUserStatsStored(long gameId, SteamResult result) {
                }

                @Override
                public void onUserStatsUnloaded(SteamID steamIDUser) {
                }

                @Override
                public void onUserAchievementStored(long gameId, boolean isGroupAchievement, String achievementName, int curProgress, int maxProgress) {
                }

                @Override
                public void onLeaderboardFindResult(SteamLeaderboardHandle leaderboard, boolean found) {
                }

                @Override
                public void onLeaderboardScoresDownloaded(SteamLeaderboardHandle leaderboard, SteamLeaderboardEntriesHandle entries, int numEntries) {
                }

                @Override
                public void onLeaderboardScoreUploaded(boolean success, SteamLeaderboardHandle leaderboard, int score, boolean scoreChanged, int globalRankNew, int globalRankPrevious) {
                }

                @Override
                public void onNumberOfCurrentPlayersReceived(boolean success, int players) {
                }

                @Override
                public void onGlobalStatsReceived(long gameId, SteamResult result) {
                }
            });
            sUM.uSF = new SteamFriends(new SteamFriendsCallback(){

                @Override
                public void onSetPersonaNameResponse(boolean success, boolean localSuccess, SteamResult result) {
                }

                @Override
                public void onPersonaStateChange(SteamID steamID, SteamFriends.PersonaChange change) {
                }

                @Override
                public void onGameOverlayActivated(boolean active) {
                }

                @Override
                public void onGameLobbyJoinRequested(SteamID steamIDLobby, SteamID steamIDFriend) {
                }

                @Override
                public void onAvatarImageLoaded(SteamID steamID, int image, int width, int height) {
                }

                @Override
                public void onFriendRichPresenceUpdate(SteamID steamIDFriend, int appID) {
                }

                @Override
                public void onGameRichPresenceJoinRequested(SteamID steamIDFriend, String connect) {
                }

                @Override
                public void onGameServerChangeRequested(String server, String password) {
                }
            });
        }
        sUM.loadSubscribedItems();
    }

    public static int getValue(String key) {
        Platform.ensureInit();
        return sUM.sUI.getStatI(key, 0);
    }

    public static Object getContext() {
        return sUM.sU;
    }

    public static void store() {
        Platform.ensureInit();
        sUM.sUI.storeStats();
    }

    private static void ensureInit() {
        if (!initialized) {
            Platform.init();
        }
        if (sUM.sUI.getStatI("app_active", -1) == -1) {
            throw new RuntimeException("Invalid platform state");
        }
    }
}

