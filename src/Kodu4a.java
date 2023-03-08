import java.util.ArrayList;

public class Kodu4a {

    public static int[] pikendatudDiagonaal(int[][] a) {
        int reaPikkus = a[0].length;
        int ridadeArv = a.length;
        int xKoordinaat = 0;
        int yKoordinaat = 0;
        boolean vastuVasakutKülge = false;
        boolean kasLangeb = true;
        boolean kasParemale = true;
        ArrayList <Integer> tagastavList = new ArrayList<>();
        tagastavList.add(a[0][0]);

        while (!(vastuVasakutKülge)) {
            while (kasLangeb) {
                xKoordinaat++;
                yKoordinaat++;
                tagastavList.add(a[yKoordinaat][xKoordinaat]);
                if (xKoordinaat == (reaPikkus - 1) && yKoordinaat == (ridadeArv - 1)) {
                    kasParemale = false;
                    kasLangeb = false;
                } else if (yKoordinaat == ridadeArv - 1) {
                    kasLangeb = false;
                    break;
                } else if (xKoordinaat == reaPikkus - 1) {
                    kasParemale = false;
                    break;
                }
            }
            while ((!kasLangeb) && kasParemale){
                xKoordinaat++;
                yKoordinaat--;
                tagastavList.add(a[yKoordinaat][xKoordinaat]);
                if (xKoordinaat == reaPikkus-1 && yKoordinaat == 0){
                    kasParemale= false;
                    kasLangeb = true;
                }else if (yKoordinaat == 0){
                    kasLangeb = true;
                    break;
                } else if (xKoordinaat == reaPikkus-1) {
                    kasParemale = false;
                    break;
                }
            }
            while (!kasLangeb){
                xKoordinaat--;
                yKoordinaat--;
                tagastavList.add(a[yKoordinaat][xKoordinaat]);
                if (xKoordinaat == 0 && yKoordinaat == 0) {
                    vastuVasakutKülge = true;
                    break;
                } else if (yKoordinaat == 0){
                    kasLangeb = true;
                    break;
                } else if (xKoordinaat == 0) {
                    vastuVasakutKülge = true;
                    break;
                }
            }
            while (kasLangeb && !(kasParemale)){
                xKoordinaat--;
                yKoordinaat++;
                tagastavList.add(a[yKoordinaat][xKoordinaat]);
                if (xKoordinaat == 0 && yKoordinaat == (ridadeArv - 1)){
                    vastuVasakutKülge = true;
                    break;
                } else if (yKoordinaat == ridadeArv-1){
                    kasLangeb = false;
                    break;
                } else if (xKoordinaat == 0) {
                    vastuVasakutKülge = true;
                    break;
                }
            }

        }
        return tagastavList.stream().mapToInt(i -> i).toArray();
    }

    public static int ruutÜhtedest(boolean [][] a){
        int ridu = a.length;
        int veerge = a[0].length;
        int [][] vasakuleÜhtedeArv = new int[ridu][veerge];
        int [][] allaÜhtedeArv = new int [ridu][veerge];
        int suurimNelinurk = 0;

        if (ridu == 1 && a[0].length == 1 && a[0][0]) return 1;

        for (int i = 0; i < ridu; i++) {
            for (int j = 0, ühtedeArv = 0; j < veerge; j++) {
                if (a[i][j]){
                    ühtedeArv++;
                } else{
                    ühtedeArv = 0;
                }
                vasakuleÜhtedeArv[i][j] = ühtedeArv;
            }
        }
        for (int i = 0; i < veerge; i++) {
            for (int j = 0, ühtedeArv = 0; j < ridu; j++) {
                if (a[j][i]){
                    ühtedeArv++;
                } else{
                    ühtedeArv = 0;
                }
                allaÜhtedeArv[j][i] = ühtedeArv;
            }
        }
        Pilt.väljasta(vasakuleÜhtedeArv);
        Pilt.väljasta(allaÜhtedeArv);

        for (int i = 0; i < vasakuleÜhtedeArv.length; i++) {
            for (int j = 1; j < vasakuleÜhtedeArv[0].length; j++) {
                if (vasakuleÜhtedeArv [i][j] > suurimNelinurk && vasakuleÜhtedeArv[i][j-1] < vasakuleÜhtedeArv [i][j] && vasakuleÜhtedeArv [i][j] > suurimNelinurk){
                    int maxArv = vasakuleÜhtedeArv [i][j];
                    if (i + maxArv <= veerge){
                        for (int k = maxArv; k > 0; k--){
                            if (vasakuleÜhtedeArv[i+k-1][j] == k && allaÜhtedeArv[i+k-1][j] >= k && allaÜhtedeArv[i + k - 1][j-k+1] >= k && k > suurimNelinurk ) {
                                System.out.println("koordinaat i" + i + "koordinaat j" + j);
                                suurimNelinurk = k;
                                break;
                            }
                        }
                    }
                }
            }
        }


        return suurimNelinurk;
    }
    
    public static int test (boolean [][] a ){
        int ridu = a.length;
        int veerge = a[0].length;
        int [][] vasakuleÜhtedeArv = new int[ridu][veerge];
        int [][] allaÜhtedeArv = new int [ridu][veerge];
        int suurimNelinurk = 0;

        if (ridu == 1 && a[0].length == 1 && a[0][0]) return 1;

        for (int i = 0; i < ridu; i++) {
            for (int j = 0, ühtedeArv = 0; j < veerge; j++) {
                if (a[i][j]){
                    ühtedeArv++;
                } else{
                    ühtedeArv = 0;
                }
                vasakuleÜhtedeArv[i][j] = ühtedeArv;
            }
        }
        for (int i = 0; i < veerge; i++) {
            for (int j = 0, ühtedeArv = 0; j < ridu; j++) {
                if (a[j][i]){
                    ühtedeArv++;
                } else{
                    ühtedeArv = 0;
                }
                allaÜhtedeArv[j][i] = ühtedeArv;
            }
        }
        Pilt.väljasta(vasakuleÜhtedeArv);

        for (int i = 0; i < vasakuleÜhtedeArv.length; i++) {
            for (int j = 1; j < vasakuleÜhtedeArv[0].length; j++) {
                if (vasakuleÜhtedeArv [i][j] > suurimNelinurk && vasakuleÜhtedeArv[i][j-1] < vasakuleÜhtedeArv [i][j] && vasakuleÜhtedeArv [i][j] > suurimNelinurk){
                    int maxArv = vasakuleÜhtedeArv [i][j];
                    if (i + maxArv <= veerge){
                        for (int k = maxArv; k > 0; k--){
                            if (vasakuleÜhtedeArv[i+k-1][j] == k && allaÜhtedeArv[i+k-1][j] >= k && allaÜhtedeArv[i + k - 1][j-k+1] >= k && k > suurimNelinurk ) {
                                System.out.println("koordinaat i" + i + "koordinaat j" + j);
                                suurimNelinurk = k;
                                break;
                            }
                        }
                    }
                }
            }
        }


        return suurimNelinurk;
    }

    public static void main(String[] args) throws Exception {
        boolean[][] c = {
                {true, true, true, false, true, true, true},
                {true, false, true, true, true, true, false},
                {true, false, true, true, true, true, false},
                {true, false, true, false, false, true, false},
                {true, false, true, true, true, true, false},
                {true, false, false, false, false, false, false},
                {true, true, true, true, true, true, true},
        };

        boolean [][] b = {
                {false, false, false, false, false, false },
                {false, true, true, true, true, false},
                {false, true, true, false, true, false},
                {false, true, false, false, true, false},
                {false, true, false, false, true, false},
                {false, true, true, true, true, false}
        };

        boolean [][] a = Pilt.piltBooleanMaatriksiks("src/pilt.png");

        //...
        long start = System.currentTimeMillis(); //AEG KÄIMA

        int parimN = ruutÜhtedest(a);

        long stop = System.currentTimeMillis();//AEG KINNI
        System.out.println("Aega kulus " + (stop - start)
                + " milliskundit");
        System.out.println("Parim n=" + parimN);
    }//main

}//klass