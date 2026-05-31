package age.of.civilizations2.jakowski.lukasz.MapA.Challenge;

import age.of.civilizations2.jakowski.lukasz.CFG;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import java.util.ArrayList;
import java.util.List;

public class ChallengesManager {
    public static List<Challenge> challengeList = new ArrayList<Challenge>();
    public static List<String> challengesCompleted = new ArrayList<String>();
    public static int START_CHALLENGE_ID = 0;
    public static int STARTED_CHALLENGE_ID = 0;

    public static void addChallengeCompleted(String tag) {
        if (!ChallengesManager.challengesCompleted.contains(tag)) {
            ChallengesManager.challengesCompleted.add(tag);
        }
    }

    public static void addCivilization() {
    }

    public static int getChallengeCivID() {
        return 0;
    }

    public static void loadChallenges() {
        ChallengesManager.challengeList.clear();
        try {
            FileHandle file = Gdx.files.internal("map/" + CFG.map.getFileActiveMapPath() + "Challenges.json");
            if (file.exists()) {
                Json json = new Json();
                json.setIgnoreUnknownFields(true);
                String content = file.readString();
                try {
                    ConfigChallengesData data = json.fromJson(ConfigChallengesData.class, content);
                    if (data != null && data.Challenge != null) {
                        for (Object e : data.Challenge) {
                            try {
                                if (e instanceof Data_Challenges) {
                                    Data_Challenges tempData = (Data_Challenges)e;
                                    Challenge nChallenge = new Challenge();
                                    nChallenge.ID = tempData.ID;
                                    nChallenge.PLAY_AS = tempData.PLAY_AS;
                                    nChallenge.FORM_TAG = tempData.FORM_TAG;
                                    nChallenge.DESC = tempData.DESC;
                                    nChallenge.SCENARIO_TAG = tempData.SCENARIO_TAG;
                                    nChallenge.PROVINCES = tempData.PROVINCES;
                                    nChallenge.PROVINCES_FORM = tempData.PROVINCES_FORM;
                                    nChallenge.ADD_CIV_PROVINCES = tempData.ADD_CIV_PROVINCES;
                                    nChallenge.COMPLETED = tempData.COMPLETED;
                                    ChallengesManager.challengeList.add(nChallenge);
                                }
                            } catch (Exception ex) {
                                System.out.println("ChallengesManager: Skipping broken entry.");
                            }
                        }
                    }
                } catch (Exception ex) {
                    System.out.println("ChallengesManager: JSON parse failed. Challenges disabled.");
                }
            }
        }
        catch (Exception ex) {
             System.out.println("ChallengesManager: Error accessing file.");
        }
    }

    public static class Challenge {
        public int ID;
        public String PLAY_AS;
        public String FORM_TAG;
        public String DESC;
        public String SCENARIO_TAG;
        public List<Integer> PROVINCES;
        public List<Integer> PROVINCES_FORM;
        public List<Integer> ADD_CIV_PROVINCES;
        public boolean COMPLETED = false;
    }

    public static class ConfigChallengesData {
        public List<Data_Challenges> Challenge;
    }

    public static class Data_Challenges {
        public int ID;
        public String PLAY_AS;
        public String FORM_TAG;
        public String DESC;
        public String SCENARIO_TAG;
        public List<Integer> PROVINCES;
        public List<Integer> PROVINCES_FORM;
        public List<Integer> ADD_CIV_PROVINCES;
        public boolean COMPLETED = false;
    }
}
