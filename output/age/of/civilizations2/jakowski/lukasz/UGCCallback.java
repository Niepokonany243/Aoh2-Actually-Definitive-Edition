/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.codedisaster.steamworks.SteamPublishedFileID;
import com.codedisaster.steamworks.SteamResult;
import com.codedisaster.steamworks.SteamUGCCallback;
import com.codedisaster.steamworks.SteamUGCDetails;
import com.codedisaster.steamworks.SteamUGCQuery;

public class UGCCallback {
    public static void init() {
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
            }

            @Override
            public void onSubmitItemUpdate(SteamPublishedFileID steamPublishedFileID, boolean b, SteamResult steamResult) {
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
    }
}

