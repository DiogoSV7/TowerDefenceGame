package org.example.model.menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leaderboard {
    private final List<String> title;
    private final List<String> entries;
    private List<String> scores;

    public Leaderboard() throws IOException,  NullPointerException  {
        this.title = Arrays.asList(
                "##     ## ####  ######   ##     ##  ######   ######   #######  ########  ######## ",
                "##     ##  ##  ##    ##  ##     ## ##    ## ##    ## ##     ## ##     ## ##       ",
                "##     ##  ##  ##        ##     ## ##       ##       ##     ## ##     ## ##       ",
                "#########  ##  ##   #### #########  ######  ##       ##     ## ########  ######   ",
                "##     ##  ##  ##    ##  ##     ##       ## ##       ##     ## ##   ##   ##       ",
                "##     ##  ##  ##    ##  ##     ## ##    ## ##    ## ##     ## ##    ##  ##       ",
                "##     ## ####  ######   ##     ##  ######   ######   #######  ##     ## ######## ");
        this.entries = Arrays.asList("1.", "2.","3.","4.","5.","6.");
        this.scores = new ArrayList<>();
        String FILE_PATH = "src/main/scores/scores.txt";

        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
            String linha;
            while ((linha = br.readLine()) != null) {
                scores.add(linha);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(scores, Collections.reverseOrder());
    }
    public String getTitle(int i){
        return title.get(i);
    }
    public int getTitleSize(){
        return this.title.size();
    }
    public String getEntry(int i) {
        return entries.get(i);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
    public List<String> getScores() {
        return scores;
    }

    public void setScore(String var){
        scores.add(var);
    }
}
