package game_factory;
import bin.Hero;
import bin.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class update_data_base {


    public update_data_base(){

    }


    public double getPlayersAntiSygnatures(String player_id,String hero_id,String hero_id2,String hero_id3,String hero_id4,String hero_id5) throws IOException,FileNotFoundException{
        BufferedReader br = new BufferedReader(new FileReader(player_id+".txt"));
        String line;
        int iter = 0;

        while ((line=br.readLine()) != null) {
            ArrayList<Double> summary = new ArrayList<>();
            double a1;
            double a2;
            double a3;
            double a4;
            double a5;

            for (String retval : line.split("hero_id\":\"")) {

                try {

                    String hero_name = retval.substring(0, retval.lastIndexOf("\",\"last_played"));
                    if (hero_id.equals(hero_name)) {

                        String games = retval.substring(retval.lastIndexOf("against_games\":") + 15, retval.lastIndexOf(",\"against_win"));
                        String wins = retval.substring(retval.lastIndexOf("against_win\":") + 13, retval.length() - 4);


                        try {
                            Double double_games = Double.parseDouble(games);
                            Double double_wins = Double.parseDouble(wins);

                            double winrate = double_wins / double_games;
                            a1 = (winrate * 100) - 50.0;
                            //System.out.println(a1);
                            summary.add(a1);
                        }
                        catch (NumberFormatException e3){
                            Double double_games = 0.0;
                            Double double_wins = 0.0;

                            double winrate = 0.0;
                            a1 = (winrate * 100) - 50.0;
                            //System.out.println(a1);
                            summary.add(a1);
                        }
                    }
                    else if (hero_id2.equals(hero_name)){
                        String games = retval.substring(retval.lastIndexOf("against_games\":") + 15, retval.lastIndexOf(",\"against_win"));
                        String wins = retval.substring(retval.lastIndexOf("against_win\":") + 13, retval.length() - 4);

                        try {
                            Double double_games = Double.parseDouble(games);
                            Double double_wins = Double.parseDouble(wins);

                            double winrate = double_wins / double_games;
                            a2 = (winrate * 100) - 50.0;
                            //System.out.println(a2);
                            summary.add(a2);
                        }
                        catch (NumberFormatException e98){
                            Double double_games = 0.0;
                            Double double_wins = 0.0;

                            double winrate = 0.0;
                            a2 = (winrate * 100) - 50.0;
                            //System.out.println(a2);
                            summary.add(a2);
                        }
                    }
                    else if (hero_id3.equals(hero_name)){
                        String games = retval.substring(retval.lastIndexOf("against_games\":") + 15, retval.lastIndexOf(",\"against_win"));
                        String wins = retval.substring(retval.lastIndexOf("against_win\":") + 13, retval.length() - 4);

                        try {

                            Double double_games = Double.parseDouble(games);
                            Double double_wins = Double.parseDouble(wins);

                            double winrate = double_wins / double_games;
                            a3 = (winrate * 100) - 50.0;
                            //System.out.println(a3);
                            summary.add(a3);
                        }
                        catch (NumberFormatException e992){

                            Double double_games = 0.0;
                            Double double_wins = 0.0;

                            double winrate = 0.0;
                            a3 = (winrate * 100) - 50.0;
                            //System.out.println(a3);
                            summary.add(a3);
                        }
                    }
                    else if (hero_id4.equals(hero_name)){
                        String games = retval.substring(retval.lastIndexOf("against_games\":") + 15, retval.lastIndexOf(",\"against_win"));
                        String wins = retval.substring(retval.lastIndexOf("against_win\":") + 13, retval.length() - 4);


                        try {
                            Double double_games = Double.parseDouble(games);
                            Double double_wins = Double.parseDouble(wins);

                            double winrate = double_wins / double_games;
                            a4 = (winrate * 100) - 50.0;
                            //System.out.println(a4);
                            summary.add(a4);
                        }
                        catch (NumberFormatException e235){
                            Double double_games = 0.0;
                            Double double_wins = 0.0;

                            double winrate = 0.0;
                            a4 = (winrate * 100) - 50.0;
                            //System.out.println(a4);
                            summary.add(a4);
                        }
                    }
                    else if (hero_id5.equals(hero_name)){
                        String games = retval.substring(retval.lastIndexOf("against_games\":") + 15, retval.lastIndexOf(",\"against_win"));
                        String wins = retval.substring(retval.lastIndexOf("against_win\":") + 13, retval.length() - 4);


                        try {
                            Double double_games = Double.parseDouble(games);
                            Double double_wins = Double.parseDouble(wins);

                            double winrate = double_wins / double_games;
                            a5 = (winrate * 100) - 50.0;
                            //System.out.println(a5);
                            summary.add(a5);
                        }
                        catch (NumberFormatException e34211){
                            Double double_games = 0.0;
                            Double double_wins = 0.0;

                            double winrate = 0.0;
                            a5 = (winrate * 100) - 50.0;
                            //System.out.println(a5);
                            summary.add(a5);
                        }
                    }
                }
                catch (StringIndexOutOfBoundsException e){
                    continue;
                }
            }


            double answer = 0.0;
            for (int i = 0; i <summary.size() ; i++) {
                answer+=summary.get(i);
            }
            return answer;
        }

        return 0.0;

    }

    public double getPlayerSignature(String player_id,String hero_id) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(player_id+".txt"));
        String line;
        int iter = 0;
        while ((line=br.readLine()) != null) {

            for (String retval : line.split("hero_id\":\"")) {

                try{
                    String hero_name = retval.substring(0,retval.lastIndexOf("\",\"last_played"));
                    if(hero_id.equals(hero_name)){

                        String games = retval.substring(retval.lastIndexOf("\"games\":")+8,retval.lastIndexOf(",\"win\""));
                        String wins = retval.substring(retval.lastIndexOf("\"win\":")+6,retval.lastIndexOf(",\"with_games"));

                        Double double_games = Double.parseDouble(games);
                        Double double_wins = Double.parseDouble(wins);

                        Double winrate =double_wins/double_games;
                        Double answer = (winrate*100)-50.0;

                        return answer;
                    }
                    else continue;
                }
                catch (StringIndexOutOfBoundsException e){
                    continue;
                }
            }

            }

        return 0.0;
    }

    public double getTeamSignatures(String team_id,String hero_id) throws FileNotFoundException , IOException{

        BufferedReader br = new BufferedReader(new FileReader(team_id+".txt"));
        String line;
        int iter = 0;
        while ((line=br.readLine()) != null) {

            for (String retval : line.split("\"hero_id\":")) {

                try{
                    String hero_name = retval.substring(0,retval.lastIndexOf(",\"localized_nam"));
                    if(hero_id.equals(hero_name)){

                        String games = retval.substring(retval.lastIndexOf("games_played\":")+14,retval.lastIndexOf(",\"wins\""));
                        String wins = retval.substring(retval.lastIndexOf("\"wins\":")+7,retval.length()-3);


                        Double double_games = Double.parseDouble(games);
                        Double double_wins = Double.parseDouble(wins);

                        Double winrate =double_wins/double_games;
                        Double answer = (winrate*100)-50.0;

                        return answer;
                    }
                    else continue;
                }
                catch (StringIndexOutOfBoundsException e){
                    continue;
                }
                catch (NumberFormatException e1){
                    continue;
                }
            }

        }
        return 0.0;
    }

    public void getLiveMatches() throws InterruptedException{


        try
        {
            Document document = Jsoup.connect("https://api.opendota.com/api/live").ignoreContentType(true).get();
            String main = document.body().text();
            for (String retval : main.split("deactivate_time\":")) {

                try {
                    //Thread.sleep(1000);
                    String isLive = retval.substring(0, retval.lastIndexOf(",\"server_steam_id\":"));
                    //System.out.println("live is "+isLive+"|");
                    if(!isLive.equals("0")){
                        //System.out.println("not live");
                        continue;
                    }

                }

                catch (StringIndexOutOfBoundsException e6){

                    //System.out.println("HERE -1");
                }

                ArrayList<String> hero_ids = new ArrayList<>();
                ArrayList<String> accounts_ids = new ArrayList<>();

                Map<String,String> playerOnHero = new TreeMap<>();


                try {
                    String radiant_team = retval.substring(retval.lastIndexOf("team_name_radiant\":\"")+20, retval.lastIndexOf("\",\"team_name_dire\""));
                    String dire_team = retval.substring(retval.lastIndexOf("team_name_dire\":\"")+17, retval.lastIndexOf("\",\"team_logo_radiant"));
                    String team_id_dire =retval.substring(retval.lastIndexOf("team_id_dire\":")+14,retval.lastIndexOf(",\"sort_score"));
                    String team_id_radiant = retval.substring(retval.lastIndexOf("team_id_radiant\":")+17 , retval.lastIndexOf(",\"team_id_dire"));
                    System.out.println(radiant_team+" versus "+ dire_team);
                    System.out.println(team_id_radiant+" versus "+team_id_dire);



                        for (String retval2 : retval.split("account_id\":")) {

                        if(retval2.contains("hero_id")) {
                            if(retval2.contains(",\"name\":\"")){

                                String hero_id = retval2.substring(retval2.lastIndexOf("hero_id\":")+9,retval2.lastIndexOf(",\"name\":"));
                                String account_id = retval2.substring(0,retval2.lastIndexOf(",\"hero_id"));
                                accounts_ids.add(account_id);
                                hero_ids.add(hero_id);
                                playerOnHero.put(account_id,hero_id);
                                //System.out.println(account_id);
                                //System.out.println(account_id+" play "+hero_id);
                            }
                            else if(retval2.contains("building_state")){
                                String hero_id = retval2.substring(retval2.lastIndexOf("hero_id\":")+9,retval2.lastIndexOf("}],\"building_state\""));
                                String account_id = retval2.substring(0,retval2.lastIndexOf(",\"hero_id"));
                                accounts_ids.add(account_id);
                                hero_ids.add(hero_id);
                                playerOnHero.put(account_id,hero_id);
                                //System.out.println(account_id);

                                //System.out.println(account_id+" play "+hero_id);

                            }
                            else {
                                String hero_id = retval2.substring(retval2.lastIndexOf("hero_id\":")+9,retval2.lastIndexOf("},{"));
                                String account_id = retval2.substring(0,retval2.lastIndexOf(",\"hero_id"));
                                accounts_ids.add(account_id);
                                hero_ids.add(hero_id);
                                playerOnHero.put(account_id,hero_id);
                               // System.out.println(account_id+" play "+hero_id);
                            }


                        }
                    }

                        if(hero_ids.size()==10){


                            ArrayList<String> currentRadTeamPlayers = new ArrayList<>();

                            try {
                                String strrad;
                                BufferedReader read_rad = new BufferedReader(new FileReader("T:" + team_id_radiant + ".txt"));

                                while ((strrad=read_rad.readLine()) != null) {

                                    //System.out.println(radiant_team+" players ");
                                    for (String players : strrad.split("\"account_id\":")) {
                                        try {
                                            String player_id = players.substring(0, players.lastIndexOf(",\"name\":"));

                                            String if_curr_member = players.substring(players.lastIndexOf("team_member\":")+13,players.length()-3);
                                            if(!if_curr_member.equals("false")){
                                                //currentRadTeamPlayers.add(player_id);
                                            }
                                            currentRadTeamPlayers.add(player_id);

                                            //System.out.println(player_id);
                                        } catch (StringIndexOutOfBoundsException e5) {

                                            //System.out.println("here 0");
                                        }

                                    }
                                }
                            }
                            catch (Exception e23){
                                Document document1= Jsoup.connect("https://api.opendota.com/api/teams/"+team_id_radiant+"/players").ignoreContentType(true).get();
                                String main1= document1.body().text();
                                PrintWriter file_writer = new PrintWriter("T:" + team_id_radiant + ".txt", "UTF-8");
                                System.out.println("downloading team...");
                                file_writer.println(main1);
                                file_writer.close();
                            }





                            ArrayList<String> currentDireTeamPlayers = new ArrayList<>();


                            try {
                                String strdire;
                                BufferedReader read_dire = new BufferedReader(new FileReader("T:" + team_id_dire + ".txt"));
                                //System.out.println(dire_team+" players ");

                                while ((strdire = read_dire.readLine()) != null) {
                                    for (String players : strdire.split("\"account_id\":")) {
                                        try {
                                            String player_id = players.substring(0, players.lastIndexOf(",\"name\":"));
                                            String if_curr_member = players.substring(players.lastIndexOf("team_member\":")+13,players.length()-3);
                                            if(!if_curr_member.equals("false")){
                                               // currentDireTeamPlayers.add(player_id);
                                                //currentDireTeamPlayers.add(player_id);

                                            }
                                            currentDireTeamPlayers.add(player_id);

                                            //System.out.println(player_id);
                                        } catch (StringIndexOutOfBoundsException e5) {
                                            //System.out.println("here 1");

                                        }

                                    }
                                }
                            }
                            catch (Exception e45){

                                Document document2= Jsoup.connect("https://api.opendota.com/api/teams/"+team_id_dire+"/players").ignoreContentType(true).get();
                                String main2= document2.body().text();
                                System.out.println("downloading team...");
                                PrintWriter file_writer = new PrintWriter("T:" + team_id_dire + ".txt", "UTF-8");
                                file_writer.println(main2);
                                file_writer.close();

                            }

                            ArrayList<String> currentRadPick = new ArrayList<>();
                            ArrayList<String> currentDirePick = new ArrayList<>();
                            ArrayList<String> currentRadPlayers = new ArrayList<>();
                            ArrayList<String> currentDirePlayers = new ArrayList<>();


                            Hero hero = new Hero();
                            for (Map.Entry<String, String> entry : playerOnHero.entrySet()) {
                                for (int i = 0; i <currentRadTeamPlayers.size() ; i++) {
                                    if(entry.getKey().equals(currentRadTeamPlayers.get(i))){
                                        currentRadPick.add(hero.getHeroNameClear(entry.getValue()));
                                        currentRadPlayers.add(currentRadTeamPlayers.get(i));
                                    }
                                }
                            }



                            for (Map.Entry<String, String> entry : playerOnHero.entrySet()) {
                                for (int i = 0; i <currentDireTeamPlayers.size() ; i++) {
                                    if(entry.getKey().equals(currentDireTeamPlayers.get(i))){
                                        currentDirePick.add(hero.getHeroNameClear(entry.getValue()));
                                        currentDirePlayers.add(currentDireTeamPlayers.get(i));
                                    }
                                }
                            }



                            read_game_history history1 = new read_game_history();

                            try {
                                history1.createMatchups(currentDirePick.get(0), currentDirePick.get(1), currentDirePick.get(2), currentDirePick.get(3), currentDirePick.get(4)
                                        , currentRadPick.get(0),currentRadPick.get(1), currentRadPick.get(2), currentRadPick.get(3), currentRadPick.get(4));


                            }
                            catch (Exception e45){
                                //e45.printStackTrace();
                                System.out.println();

                                System.out.println("NO DATA FOR THIS TEAMS");
                                continue;
                            }
                            File file = new File("/Users/user/Downloads/dota_scraper_2/Pick_Adventures.txt");
                            String st;
                            int value = 0;
                            BufferedReader br = new BufferedReader(new FileReader(file));
                            ArrayList<Double> win1 = new ArrayList<>();
                            ArrayList<Double> win2 = new ArrayList<>();
                            while ((st = br.readLine()) != null) {
                                value++;

                                if (value > 1 && value <= 6) {
                                    win1.add(Double.parseDouble(st.replace(",",".")));
                                }

                                else if(value >=9 && value<=13){
                                    win2.add(Double.parseDouble(st.replace(",",".")));
                                }
                            }

                            double sum1 = 0.0;
                            double sum2 = 0.0;
                            for (int i = 0; i < win1.size(); i++) {
                                sum1 += win1.get(i);
                            }
                            for (int i = 0; i < win2.size(); i++) {
                                sum2 += win2.get(i);
                            }



                            try {


                                double a;
                                double b;
                                double c;
                                double d;
                                double e;
                                double f;


                                update_data_base base = new update_data_base();
                                read_game_history history = new read_game_history();


                                double a1 = base.getPlayerSignature(currentRadPlayers.get(0),history.getHeroId(currentRadPick.get(0)));
                                double a2 = base.getPlayerSignature(currentRadPlayers.get(1),history.getHeroId(currentRadPick.get(1)));
                                double a3 = base.getPlayerSignature(currentRadPlayers.get(2),history.getHeroId(currentRadPick.get(2)));
                                double a4 = base.getPlayerSignature(currentRadPlayers.get(3),history.getHeroId(currentRadPick.get(3)));
                                double a5 = base.getPlayerSignature(currentRadPlayers.get(4),history.getHeroId(currentRadPick.get(4)));



                                double b1 = base.getPlayerSignature(currentDirePlayers.get(0),history.getHeroId(currentDirePick.get(0)));
                                double b2 = base.getPlayerSignature(currentDirePlayers.get(1),history.getHeroId(currentDirePick.get(1)));
                                double b3 = base.getPlayerSignature(currentDirePlayers.get(2),history.getHeroId(currentDirePick.get(2)));
                                double b4 = base.getPlayerSignature(currentDirePlayers.get(3),history.getHeroId(currentDirePick.get(3)));
                                double b5 = base.getPlayerSignature(currentDirePlayers.get(4),history.getHeroId(currentDirePick.get(4)));



                                double c1 = base.getPlayersAntiSygnatures(currentRadPlayers.get(0),history.getHeroId(currentDirePick.get(0)),history.getHeroId(currentDirePick.get(1)),history.getHeroId(currentDirePick.get(2)),history.getHeroId(currentDirePick.get(3)),history.getHeroId(currentDirePick.get(4)));
                                double c2 = base.getPlayersAntiSygnatures(currentRadPlayers.get(1),history.getHeroId(currentDirePick.get(0)),history.getHeroId(currentDirePick.get(1)),history.getHeroId(currentDirePick.get(2)),history.getHeroId(currentDirePick.get(3)),history.getHeroId(currentDirePick.get(4)));
                                double c3 = base.getPlayersAntiSygnatures(currentRadPlayers.get(2),history.getHeroId(currentDirePick.get(0)),history.getHeroId(currentDirePick.get(1)),history.getHeroId(currentDirePick.get(2)),history.getHeroId(currentDirePick.get(3)),history.getHeroId(currentDirePick.get(4)));
                                double c4 = base.getPlayersAntiSygnatures(currentRadPlayers.get(3),history.getHeroId(currentDirePick.get(0)),history.getHeroId(currentDirePick.get(1)),history.getHeroId(currentDirePick.get(2)),history.getHeroId(currentDirePick.get(3)),history.getHeroId(currentDirePick.get(4)));
                                double c5 = base.getPlayersAntiSygnatures(currentRadPlayers.get(4),history.getHeroId(currentDirePick.get(0)),history.getHeroId(currentDirePick.get(1)),history.getHeroId(currentDirePick.get(2)),history.getHeroId(currentDirePick.get(3)),history.getHeroId(currentDirePick.get(4)));



                                double d1 = base.getPlayersAntiSygnatures(currentDirePlayers.get(0),history.getHeroId(currentRadPick.get(0)),history.getHeroId(currentRadPick.get(1)),history.getHeroId(currentRadPick.get(2)),history.getHeroId(currentRadPick.get(3)),history.getHeroId(currentRadPick.get(4)));
                                double d2 = base.getPlayersAntiSygnatures(currentDirePlayers.get(1),history.getHeroId(currentRadPick.get(0)),history.getHeroId(currentRadPick.get(1)),history.getHeroId(currentRadPick.get(2)),history.getHeroId(currentRadPick.get(3)),history.getHeroId(currentRadPick.get(4)));
                                double d3 = base.getPlayersAntiSygnatures(currentDirePlayers.get(2),history.getHeroId(currentRadPick.get(0)),history.getHeroId(currentRadPick.get(1)),history.getHeroId(currentRadPick.get(2)),history.getHeroId(currentRadPick.get(3)),history.getHeroId(currentRadPick.get(4)));
                                double d4 = base.getPlayersAntiSygnatures(currentDirePlayers.get(3),history.getHeroId(currentRadPick.get(0)),history.getHeroId(currentRadPick.get(1)),history.getHeroId(currentRadPick.get(2)),history.getHeroId(currentRadPick.get(3)),history.getHeroId(currentRadPick.get(4)));
                                double d5 = base.getPlayersAntiSygnatures(currentDirePlayers.get(4),history.getHeroId(currentRadPick.get(0)),history.getHeroId(currentRadPick.get(1)),history.getHeroId(currentRadPick.get(2)),history.getHeroId(currentRadPick.get(3)),history.getHeroId(currentRadPick.get(4)));




                                double e1 = base.getTeamSignatures(team_id_radiant,history.getHeroId(currentRadPick.get(0)));
                                double e2 = base.getTeamSignatures(team_id_radiant,history.getHeroId(currentRadPick.get(1)));
                                double e3 = base.getTeamSignatures(team_id_radiant,history.getHeroId(currentRadPick.get(2)));
                                double e4 = base.getTeamSignatures(team_id_radiant,history.getHeroId(currentRadPick.get(3)));
                                double e5 = base.getTeamSignatures(team_id_radiant,history.getHeroId(currentRadPick.get(4)));



                                double f1 = base.getTeamSignatures(team_id_dire, history.getHeroId(currentDirePick.get(0)));
                                double f2 = base.getTeamSignatures(team_id_dire, history.getHeroId(currentDirePick.get(1)));
                                double f3 = base.getTeamSignatures(team_id_dire, history.getHeroId(currentDirePick.get(2)));
                                double f4 = base.getTeamSignatures(team_id_dire, history.getHeroId(currentDirePick.get(3)));
                                double f5 = base.getTeamSignatures(team_id_dire, history.getHeroId(currentDirePick.get(4)));


                                if(Double.isNaN(f1)){
                                    f1=0.0;
                                    f=f1+f2+f3+f4+f5;
                                }
                                else if(Double.isNaN(f2) && Double.isNaN(f1)){
                                    f1=0.0;
                                    f2=0.0;
                                    f=f1+f2+f3+f4+f5;
                                }
                                else if (Double.isNaN(f2)){
                                    f2=0.0;
                                    f=f1+f2+f3+f4+f5;
                                }
                                else if(Double.isNaN(f2) && Double.isNaN(f3)){
                                    f3=0.0;
                                    f2=0.0;
                                    f=f1+f2+f3+f4+f5;
                                }

                                else if(Double.isNaN(f3)){
                                    f3=0.0;
                                    f=f1+f2+f3+f4+f5;
                                }
                                else if(Double.isNaN(f3) && Double.isNaN(f4)){
                                    f3=0.0;
                                    f4=0.0;
                                    f=f1+f2+f3+f4+f5;
                                }
                                else if(Double.isNaN(f4)){
                                    f4=0.0;
                                    f=f1+f2+f3+f4+f5;
                                }
                                else if(Double.isNaN(f4) && Double.isNaN(f5)){
                                    f4=0.0;
                                    f5=0.0;
                                    f=f1+f2+f3+f4+f5;
                                }
                                else if(Double.isNaN(f5)){
                                    f5=0.0;
                                    f=f1+f2+f3+f4+f5;
                                }

                                f=f1+f2+f3+f4+f5;



                                if(Double.isNaN(e1)){
                                    e1=0.0;
                                    e=e1+e2+e3+e4+e5;
                                }
                                else if(Double.isNaN(e2) && Double.isNaN(e1)){
                                    e1=0.0;
                                    e2=0.0;
                                    e=e1+e2+e3+e4+e5;
                                }
                                else if (Double.isNaN(e2)){
                                    e2=0.0;
                                    e=e1+e2+e3+e4+e5;
                                }
                                else if(Double.isNaN(e2) && Double.isNaN(e3)){
                                    e3=0.0;
                                    e2=0.0;
                                    e=e1+e2+e3+e4+e5;
                                }

                                else if(Double.isNaN(e3)){
                                    e3=0.0;
                                    e=e1+e2+e3+e4+e5;
                                }
                                else if(Double.isNaN(e3) && Double.isNaN(e4)){
                                    e3=0.0;
                                    e4=0.0;
                                    e=e1+e2+e3+e4+e5;
                                }
                                else if(Double.isNaN(e4)){
                                    e4=0.0;
                                    e=e1+e2+e3+e4+e5;
                                }
                                else if(Double.isNaN(e4) && Double.isNaN(e5)){
                                    e4=0.0;
                                    e5=0.0;
                                    e=e1+e2+e3+e4+e5;
                                }
                                else if(Double.isNaN(e5)){
                                    e5=0.0;
                                    e=e1+e2+e3+e4+e5;
                                }

                                e=e1+e2+e3+e4+e5;


                                if(Double.isNaN(d1)){
                                    d1=0.0;
                                    d=d1+d2+d3+d4+d5;
                                }
                                else if(Double.isNaN(d2) && Double.isNaN(d1)){
                                    d1=0.0;
                                    d2=0.0;
                                    d=d1+d2+d3+d4+d5;
                                }
                                else if (Double.isNaN(d2)){
                                    d2=0.0;
                                    d=d1+d2+d3+d4+d5;
                                }
                                else if(Double.isNaN(d2) && Double.isNaN(d3)){
                                    d3=0.0;
                                    d2=0.0;
                                    d=d1+d2+d3+d4+d5;
                                }

                                else if(Double.isNaN(d3)){
                                    d3=0.0;
                                    d=d1+d2+d3+d4+d5;

                                }
                                else if(Double.isNaN(d3) && Double.isNaN(d4)){
                                    d3=0.0;
                                    d4=0.0;
                                    d=d1+d2+d3+d4+d5;
                                }
                                else if(Double.isNaN(d4)){
                                    d4=0.0;
                                    d=d1+d2+d3+d4+d5;
                                }
                                else if(Double.isNaN(d4) && Double.isNaN(d5)){
                                    d4=0.0;
                                    d5=0.0;
                                    d=d1+d2+d3+d4+d5;
                                }
                                else if(Double.isNaN(d5)){
                                    d5=0.0;
                                    d=d1+d2+d3+d4+d5;
                                }

                                d=d1+d2+d3+d4+d5;



                                if(Double.isNaN(c1)){
                                    c1=0.0;
                                    c=c1+c2+c3+c4+c5;
                                }
                                else if(Double.isNaN(c2) && Double.isNaN(c1)){
                                    c1=0.0;
                                    c2=0.0;
                                    c=c1+c2+c3+c4+c5;
                                }
                                else if (Double.isNaN(c2)){
                                    c2=0.0;
                                    c=c1+c2+c3+c4+c5;
                                }
                                else if(Double.isNaN(c2) && Double.isNaN(c3)){
                                    c3=0.0;
                                    c2=0.0;
                                    c=c1+c2+c3+c4+c5;
                                }

                                else if(Double.isNaN(c3)){
                                    c3=0.0;
                                    c=c1+c2+c3+c4+c5;

                                }
                                else if(Double.isNaN(c3) && Double.isNaN(c4)){
                                    c3=0.0;
                                    c4=0.0;
                                    c=c1+c2+c3+c4+c5;
                                }
                                else if(Double.isNaN(c4)){
                                    c4=0.0;
                                    c=c1+c2+c3+c4+c5;
                                }
                                else if(Double.isNaN(c4) && Double.isNaN(c5)){
                                    c4=0.0;
                                    c5=0.0;
                                    c=c1+c2+c3+c4+c5;
                                }
                                else if(Double.isNaN(c5)){
                                    c5=0.0;
                                    c=c1+c2+c3+c4+c5;
                                }

                                c=c1+c2+c3+c4+c5;


                                if(Double.isNaN(a1)){
                                    a1=0.0;
                                    a=a1+a2+a3+a4+a5;
                                }
                                else if(Double.isNaN(a2) && Double.isNaN(a1)){
                                    a1=0.0;
                                    a2=0.0;
                                    a=a1+a2+a3+a4+a5;
                                }
                                else if (Double.isNaN(a2)){
                                    a2=0.0;
                                    a=a1+a2+a3+a4+a5;
                                }
                                else if(Double.isNaN(a2) && Double.isNaN(a3)){
                                    a3=0.0;
                                    a2=0.0;
                                    a=a1+a2+a3+a4+a5;
                                }

                                else if(Double.isNaN(a3)){
                                    a3=0.0;
                                    a=a1+a2+a3+a4+a5;

                                }
                                else if(Double.isNaN(a3) && Double.isNaN(a4)){
                                    a3=0.0;
                                    a4=0.0;
                                    a=a1+a2+a3+a4+a5;
                                }
                                else if(Double.isNaN(a4)){
                                    a4=0.0;
                                    a=a1+a2+a3+a4+a5;
                                }
                                else if(Double.isNaN(a4) && Double.isNaN(a5)){
                                    a4=0.0;
                                    a5=0.0;
                                    a=a1+a2+a3+a4+a5;
                                }
                                else if(Double.isNaN(a5)){
                                    a5=0.0;
                                    a=a1+a2+a3+a4+a5;
                                }

                                a=a1+a2+a3+a4+a5;

                                if(Double.isNaN(b1)){
                                    b1=0.0;
                                    b=b1+b2+b3+b4+b5;
                                }
                                else if(Double.isNaN(b2) && Double.isNaN(b1)){
                                    b1=0.0;
                                    b2=0.0;
                                    b=b1+b2+b3+b4+b5;
                                }
                                else if (Double.isNaN(b2)){
                                    b2=0.0;
                                    b=b1+b2+b3+b4+b5;
                                }
                                else if(Double.isNaN(b2) && Double.isNaN(b3)){
                                    b3=0.0;
                                    b2=0.0;
                                    b=b1+b2+b3+b4+b5;
                                }
                                else if(Double.isNaN(b3)){
                                    b3=0.0;
                                    b=b1+b2+b3+b4+b5;
                                }
                                else if(Double.isNaN(b3) && Double.isNaN(b4)){
                                    b3=0.0;
                                    b4=0.0;
                                    b=b1+b2+b3+b4+b5;
                                }
                                else if(Double.isNaN(b4)){
                                    b4=0.0;
                                    b=b1+b2+b3+b4+b5;
                                }
                                else if(Double.isNaN(b4) && Double.isNaN(b5)){
                                    b4=0.0;
                                    b5=0.0;
                                    b=b1+b2+b3+b4+b5;
                                }
                                else if(Double.isNaN(b5)){
                                    b5=0.0;
                                    b=b1+b2+b3+b4+b5;
                                }



                                b=b1+b2+b3+b4+b5;


                                double sum_a_synergy = history.synergyRate(currentRadPick.get(0), currentRadPick.get(1), currentRadPick.get(2), currentRadPick.get(3), currentRadPick.get(4)) + history.synergyRate(currentRadPick.get(1), currentRadPick.get(0), currentRadPick.get(2), currentRadPick.get(3), currentRadPick.get(4)) +
                                        history.synergyRate(currentRadPick.get(2), currentRadPick.get(1), currentRadPick.get(0), currentRadPick.get(3), currentRadPick.get(4)) + history.synergyRate(currentRadPick.get(3), currentRadPick.get(0), currentRadPick.get(1), currentRadPick.get(2), currentRadPick.get(4)) +
                                        history.synergyRate(currentRadPick.get(4), currentRadPick.get(0), currentRadPick.get(1), currentRadPick.get(2), currentRadPick.get(3));


                                double sum_b_synergy = history.synergyRate(currentDirePick.get(0), currentDirePick.get(1), currentDirePick.get(2), currentDirePick.get(3), currentDirePick.get(4)) + history.synergyRate(currentDirePick.get(1), currentDirePick.get(0), currentDirePick.get(2), currentDirePick.get(3), currentDirePick.get(4))
                                        + history.synergyRate(currentDirePick.get(2), currentDirePick.get(0), currentDirePick.get(1), currentDirePick.get(3), currentDirePick.get(4)) +
                                        history.synergyRate(currentDirePick.get(3), currentDirePick.get(0), currentDirePick.get(1), currentDirePick.get(2), currentDirePick.get(4)) +
                                        history.synergyRate(currentDirePick.get(4), currentDirePick.get(0), currentDirePick.get(1), currentDirePick.get(2), currentDirePick.get(3));

                                double meta_dire = history.metaHeroesWinrate(currentRadPick.get(0), currentRadPick.get(1), currentRadPick.get(2), currentRadPick.get(3), currentRadPick.get(4));
                                double meta_rad = history.metaHeroesWinrate(currentDirePick.get(0), currentDirePick.get(1), currentDirePick.get(2), currentDirePick.get(3), currentDirePick.get(4));



                                test test = new test();
                                test.calculateCountrPick(currentRadPick.get(0),currentDirePick.get(0),currentDirePick.get(1),currentDirePick.get(2),currentDirePick.get(3),currentDirePick.get(4));
                                test.calculateCountrPick(currentRadPick.get(1),currentDirePick.get(0),currentDirePick.get(1),currentDirePick.get(2),currentDirePick.get(3),currentDirePick.get(4));
                                test.calculateCountrPick(currentRadPick.get(2),currentDirePick.get(0),currentDirePick.get(1),currentDirePick.get(2),currentDirePick.get(3),currentDirePick.get(4));
                                test.calculateCountrPick(currentRadPick.get(3),currentDirePick.get(0),currentDirePick.get(1),currentDirePick.get(2),currentDirePick.get(3),currentDirePick.get(4));
                                test.calculateCountrPick(currentRadPick.get(4),currentDirePick.get(0),currentDirePick.get(1),currentDirePick.get(2),currentDirePick.get(3),currentDirePick.get(4));

                                System.out.println("*************************");

                                test.calculateCountrPick(currentDirePick.get(0),currentRadPick.get(0),currentRadPick.get(1),currentRadPick.get(2),currentRadPick.get(3),currentRadPick.get(4));
                                test.calculateCountrPick(currentDirePick.get(1),currentRadPick.get(0),currentRadPick.get(1),currentRadPick.get(2),currentRadPick.get(3),currentRadPick.get(4));
                                test.calculateCountrPick(currentDirePick.get(2),currentRadPick.get(0),currentRadPick.get(1),currentRadPick.get(2),currentRadPick.get(3),currentRadPick.get(4));
                                test.calculateCountrPick(currentDirePick.get(3),currentRadPick.get(0),currentRadPick.get(1),currentRadPick.get(2),currentRadPick.get(3),currentRadPick.get(4));
                                test.calculateCountrPick(currentDirePick.get(4),currentRadPick.get(0),currentRadPick.get(1),currentRadPick.get(2),currentRadPick.get(3),currentRadPick.get(4));



                                String fc1 = String.format("%.2f", a);
                                String fc2 = String.format("%.2f", b);
                                String fc3 = String.format("%.2f", sum1);
                                String fc4 = String.format("%.2f", sum2);
                                String fc5 = String.format("%.2f", sum_a_synergy);
                                String fc6 = String.format("%.2f", sum_b_synergy);
                                String fc7 = String.format("%.2f", c);
                                String fc8 = String.format("%.2f", d);
                                String fc9 = String.format("%.2f", e);
                                String fc10 = String.format("%.2f", f);

                                String fa1 = String.format("%.2f", a1);
                                String fa2 = String.format("%.2f", a2);
                                String fa3 = String.format("%.2f", a3);
                                String fa4 = String.format("%.2f", a4);
                                String fa5 = String.format("%.2f", a5);

                                String fb1 = String.format("%.2f", b1);
                                String fb2 = String.format("%.2f", b2);
                                String fb3 = String.format("%.2f", b3);
                                String fb4 = String.format("%.2f", b4);
                                String fb5 = String.format("%.2f", b5);



                                System.out.println("**************************");
                                System.out.println("**************************");
                                System.out.println("*******" + radiant_team + "*******");
                                System.out.println("**************************");
                                System.out.println("**************************");
                                System.out.println(radiant_team+" TEAM SIGNATURES : "+fc9);
                                System.out.println(radiant_team+" PLAYERS SIGNATURE :"+fc1 +" ( "+currentRadPick.get(0)+": "+fa1+"|"+currentRadPick.get(1)+": "+fa2+"|"+currentRadPick.get(2)+": "+fa3+"|"+currentRadPick.get(3)+": "+fa4+"|"+currentRadPick.get(4)+": "+fa5+" )");
                                System.out.println(radiant_team+" PLAYERS ANTI SIGNATURE :"+fc7);
                                System.out.println(radiant_team+" SUM COUNTR : " + fc3);
                                System.out.println(radiant_team+" SUM SYNERGY : " + fc5);
                                System.out.println(radiant_team+" META WINRATE: " + meta_dire);
                                System.out.println("**************************");
                                System.out.println("**************************");
                                System.out.println("*******" + dire_team + "*******");
                                System.out.println("**************************");
                                System.out.println("**************************");
                                System.out.println(dire_team+" TEAM SIGNATURES : "+fc10);
                                System.out.println(dire_team+" PLAYERS SIGNATURE :"+fc2+" ( "+currentDirePick.get(0)+": "+fb1+"|"+currentDirePick.get(1)+": "+fb2+"|"+currentDirePick.get(2)+": "+fb3+"|"+currentDirePick.get(3)+": "+fb4+"|"+currentDirePick.get(4)+": "+fb5+ " ) ");
                                System.out.println(dire_team+" PLAYERS  ANTI SIGNATURE :"+fc8);
                                System.out.println(dire_team+" SUM COUNTR : " + fc4);
                                System.out.println(dire_team+" SUM SYNERGY : " + fc6);
                                System.out.println(dire_team+" META WINRATE: " + meta_rad);

                                System.out.println("-----------------------------------------");

                                File file1 = new File("/Users/user/Downloads/dota_scraper_2/Core_Adventures.txt");
                                String st1;
                                int value1 = 0;
                                BufferedReader br1 = new BufferedReader(new FileReader(file1));
                                ArrayList<Double> win3 = new ArrayList<>();
                                ArrayList<Double> win4 = new ArrayList<>();
                                while ((st1 = br1.readLine()) != null) {
                                    value1++;
                                    if (value1 > 1 && value1 <= 4) {
                                        win3.add(Double.parseDouble(st1.replace(",", ".")));
                                    } else if (value1 >= 7 && value1 <= 9) {
                                        win4.add(Double.parseDouble(st1.replace(",", ".")));
                                    }
                                }

                                double sum3 = 0.0;
                                double sum4 = 0.0;
                                for (int i = 0; i < win3.size(); i++) {
                                    sum3 += win3.get(i);
                                }
                                for (int i = 0; i < win4.size(); i++) {
                                    sum4 += win4.get(i);
                                }


                                if ((sum1 > sum2 && sum1 > 85 && sum_a_synergy > 55) || (sum_a_synergy > 150) ) {

                                    URL url2 = new URL("https://api.telegram.org/bot76832134293&text= " +dire_team);

                                    URL url = new URL("https://api.telegram.org/bot768423text= "+dire_team+" versus " + radiant_team+"!!!--| count: "+fc3+"| synergy : "+fc5+"| PLAYERS SIGNATURE :"+fc1 +" ( "+currentRadPick.get(0)+": "+fa1+"|"+currentRadPick.get(1)+": "+fa2+"|"+currentRadPick.get(2)+": "+fa3+"|"+currentRadPick.get(3)+": "+fa4+"|"+currentRadPick.get(4)+": "+fa5+" )");
                                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                                    con.setRequestMethod("GET");
                                    System.out.println("telegram response code: "+con.getResponseCode());

                                    System.out.println("BET ON " + radiant_team);
                                }
                                else if(sum_b_synergy<-150){


                                    URL url = new URL("https://api.telegram.org/bot76S4hdvzQFCtsA/sendMes65&text= "+radiant_team+"!!! vesus " + dire_team+"-- |count: "+fc4+"| synergy : "+fc6+"| PLAYERS SIGNATURE :"+fc2 +" ( "+currentDirePick.get(0)+": "+fb1+"|"+currentDirePick.get(1)+": "+fb2+"|"+currentDirePick.get(2)+": "+fb3+"|"+currentDirePick.get(3)+": "+fb4+"|"+currentDirePick.get(4)+": "+fb5+" )");
                                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                                    con.setRequestMethod("GET");
                                    System.out.println("telegram response code: "+con.getResponseCode());
                                    System.out.println("" + dire_team+" have very low synergy try to bet on their lose ");
                                }
                                else if(sum_a_synergy<-150){
                                    URL url = new URL("https://api.telegram.org/bot762318129365:312wSyP1sa_uSQxad=56ext="+dire_team+"!!! versus " + radiant_team+"" +
                                            " -| count: "+fc3+"| synergy : "+fc5+"| PLAYERS SIGNATURE :"+fc1 +" ( "+currentRadPick.get(0)+": "+fa1+"|"+currentRadPick.get(1)+": "+fa2+"|"+currentRadPick.get(2)+": "+fa3+"|"+currentRadPick.get(3)+": "+fa4+"|"+currentRadPick.get(4)+": "+fa5+" )");
                                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                                    con.setRequestMethod("GET");
                                    System.out.println("telegram response code: "+con.getResponseCode());
                                    System.out.println("" + radiant_team+"!!! have very low synergy try to bet on their lose ");
                                }

                                else if ((sum2 > sum1 && sum2 > 85 && sum_b_synergy > 55) || ( sum_b_synergy > 150)) {
                                    URL url = new URL("https://api.telegram.org/bot768429322:OAewSyP1sa_u02265&text="+radiant_team+ " versus " + dire_team+"!!!- |count: "+fc4+"| synergy : "+fc6+"| PLAYERS SIGNATURE :"+fc2 +" ( "+currentDirePick.get(0)+": "+fb1+"|"+currentDirePick.get(1)+": "+fb2+"|"+currentDirePick.get(2)+": "+fb3+"|"+currentDirePick.get(3)+": "+fb4+"|"+currentDirePick.get(4)+": "+fb5+" )");
                                    URL url2 = new URL("https://api.telegram.org/bot73142936215:A2ewSyP1sa_uNQ123xa00X65&text= " );

                                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                                    con.setRequestMethod("GET");
                                    System.out.println("telegram response code: "+con.getResponseCode());

                                    System.out.println("BET ON " + dire_team);
                                } else {
                                    System.out.println("CANT BET , NO DATA");
                                    continue;
                                }

                            }

                            catch (FileNotFoundException e6){

                                Thread.sleep(2000);
                                e6.printStackTrace();
                                System.out.println("CANT FIND DATA FOR PLAYER , downloading....");
                                for (int i = 0; i < currentRadPlayers.size(); i++) {

                                        Document document4 = Jsoup.connect("https://api.opendota.com/api/players/" + currentRadPlayers.get(i) + "/heroes").ignoreContentType(true).get();
                                        String main4 = document4.body().text();

                                            System.out.println("new player found");
                                            PrintWriter file_writer = new PrintWriter(currentRadPlayers.get(i) + "" + ".txt", "UTF-8");
                                            file_writer.println(main4);
                                            file_writer.close();
                                }


                                for (int i = 0; i < currentDirePlayers.size(); i++) {

                                    Document document4 = Jsoup.connect("https://api.opendota.com/api/players/" + currentDirePlayers.get(i) + "/heroes").ignoreContentType(true).get();
                                    String main4 = document4.body().text();

                                    System.out.println("new player found");
                                    PrintWriter file_writer = new PrintWriter(currentDirePlayers.get(i) + "" + ".txt", "UTF-8");
                                    file_writer.println(main4);
                                    file_writer.close();
                                }



                                Document document5 = Jsoup.connect("https://api.opendota.com/api/teams/" + team_id_radiant + "/heroes").ignoreContentType(true).get();
                                String main5 = document5.body().text();

                                System.out.println("new team found");
                                PrintWriter file_writer4 = new PrintWriter(team_id_radiant  + ".txt", "UTF-8");
                                file_writer4.println(main5);
                                file_writer4.close();


                                Document document6 = Jsoup.connect("https://api.opendota.com/api/teams/" + team_id_dire + "/heroes").ignoreContentType(true).get();
                                String main6 = document6.body().text();

                                System.out.println("new team found");
                                PrintWriter file_writer1 = new PrintWriter(team_id_dire + ".txt", "UTF-8");
                                file_writer1.println(main6);
                                file_writer1.close();

                            }
                            catch (Exception ejg4){
                                System.out.println("HELO");
                                ejg4.printStackTrace();
                                continue;
                            }

                        }

                    }
                catch (IndexOutOfBoundsException e){

                    //e.printStackTrace();

                    //System.out.println("here 2");
                    continue;
                }

            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        }

        public void readHeroFile(String hero_name) throws IOException
        {
            BufferedReader br = new BufferedReader(new FileReader(hero_name+"_matchups_from_16.08.2019.txt"));
            String line;
            int iter = 0;

            while ((line=br.readLine()) != null) {

                for (String retval : line.split("hero_id\":")) {

                    try {
                        String id = retval.substring(0, retval.lastIndexOf(",\"games"));
                        String games_played = retval.substring(retval.lastIndexOf("played\":")+8, retval.lastIndexOf(",\"wins"));
                        String wins = retval.substring(retval.lastIndexOf("wins\":")+6, retval.length()-4);
                        Hero hero2 = new Hero();
                        String name = hero2.getHeroNameClear(id);

                        double a = Double.parseDouble(games_played);
                        double b = Double.parseDouble(wins);
                        double c = 0.0;

                        c=b/a;


                        if(c<0.44 && c>0.2) {
                            String x = String.format("%.2f", c);
                            System.out.println(hero_name+" bad versus "+name + "  " + x);

                        }
                        else if (c<0.2){
                            String x = String.format("%.2f", c);
                            System.out.println(hero_name+" worst versus "+name + "  " + x);

                        }
                        else if(c>0.6){
                            String x = String.format("%.2f", c);
                            System.out.println(hero_name+" good versus "+name + "  " + x);
                        }
                        else if (c>0.75 && c<1.00){
                            String x = String.format("%.2f", c);
                            System.out.println(hero_name+" best versus "+name + "  " + x);
                        }

                    }
                    catch (StringIndexOutOfBoundsException  e2){
                        continue;
                    }
                }

                }

        }
    public static void main(String[] args)  throws IOException, InterruptedException {
        update_data_base base = new update_data_base();

        base.getLiveMatches();
    }


}
