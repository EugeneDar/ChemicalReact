package com.barbar.chemicalreact;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reactions {

    private static class InitList extends ArrayList<String> {

        public List<String> result;

        public InitList(String a, String b, String c, String... result) {
            super();
            this.add(a);
            if (!b.equals("")) {
                this.add(b);
            }
            this.add(c);
            this.result = Arrays.asList(result);
        }

    }

    static List<List<String>> reactionsList = new ArrayList<>();

    public static void initialize () {

        // ₀₁₂₃₄₅₆₇₈₉

        //////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////

        reactionsList.add(new InitList("H₂", "O₂", "Heat", "H₂O"));
        reactionsList.add(new InitList("H₂", "O₂", "Electricity", "H₂O"));
        reactionsList.add(new InitList("Na", "O₂", "Nothing", "Na₂O"));
        reactionsList.add(new InitList("K", "O₂", "Nothing", "K₂O"));
        reactionsList.add(new InitList("Li", "O₂", "Nothing", "Li₂O"));
        reactionsList.add(new InitList("Be", "O₂", "Nothing", "BeO"));
        reactionsList.add(new InitList("Ca", "O₂", "Heat", "CaO"));
        reactionsList.add(new InitList("Mg", "O₂", "Heat", "MgO"));

        reactionsList.add(new InitList("Mn", "O₂", "Nothing", "Mn₂O₇", "MnO₂"));
        reactionsList.add(new InitList("Fe", "O₂", "Nothing", "Fe₂O₃", "FeO"));
        reactionsList.add(new InitList("Cu", "O₂", "Nothing", "CuO"));
        reactionsList.add(new InitList("Zn", "O₂", "Nothing", "ZnO"));
        reactionsList.add(new InitList("B", "O₂", "Nothing", "B₂O₃"));

        reactionsList.add(new InitList("F₂", "O₂", "Electricity", "OF₂"));
        reactionsList.add(new InitList("Al", "O₂", "Nothing", "Al₂O₃"));
        reactionsList.add(new InitList("Ag", "O₂", "Nothing", "Ag₂O"));
        reactionsList.add(new InitList("Hg", "O₂", "Nothing", "HgO"));
        reactionsList.add(new InitList("Si", "O₂", "Nothing", "SiO₂"));

        reactionsList.add(new InitList("P", "O₂", "Nothing", "P₂O₅"));
        reactionsList.add(new InitList("Sr", "O₂", "Heat", "SrO"));
        reactionsList.add(new InitList("Ba", "O₂", "Heat", "BaO"));

        reactionsList.add(new InitList("N₂", "O₂", "Electricity", "NO", "N₂O₅"));
        reactionsList.add(new InitList("NO", "O₂", "Nothing", "NO₂"));

        reactionsList.add(new InitList("S", "O₂", "Nothing", "SO₂"));
        reactionsList.add(new InitList("SO₂", "O₂", "Heat", "SO₃"));

        reactionsList.add(new InitList("C", "O₂", "Heat", "CO", "CO₂"));
        reactionsList.add(new InitList("CO", "O₂", "Heat", "CO₂"));
        reactionsList.add(new InitList("С", "H₂O", "Nothing", "CO", "H₂"));

        // Be, Ba, Mn, Fe, Cu, Zn, Hg, Ag

        //////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////

        reactionsList.add(new InitList("H₂", "Cl₂", "Light", "HCl"));
        reactionsList.add(new InitList("H₂", "S", "Heat", "H₂S"));
        reactionsList.add(new InitList("H₂", "Br₂", "Heat", "HBr"));
        reactionsList.add(new InitList("H₂", "F₂", "Nothing", "HF"));

        reactionsList.add(new InitList("H₂O", "CO₂", "Nothing", "H₂CO₃"));
        reactionsList.add(new InitList("H₂O", "NO₂", "Nothing", "HNO₂", "HNO₃"));
        reactionsList.add(new InitList("H₂O", "N₂O₅", "Nothing", "HNO₃"));
        reactionsList.add(new InitList("H₂O", "SO₃", "Nothing", "H₂SO₄"));
        reactionsList.add(new InitList("H₂O", "SO₂", "Nothing", "H₂SO₃"));
        reactionsList.add(new InitList("H₂O", "P₂O₅", "Nothing", "H₃PO₄"));

        //////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////

        reactionsList.add(new InitList("H₂O", "Li", "Nothing", "LiOH", "H₂"));
        reactionsList.add(new InitList("H₂O", "Na", "Nothing", "NaOH", "H₂"));
        reactionsList.add(new InitList("H₂O", "K", "Nothing", "KOH", "H₂"));
        reactionsList.add(new InitList("H₂O", "Be", "Nothing", "Be(OH)₂", "H₂"));
        reactionsList.add(new InitList("H₂O", "Mg", "Nothing", "Mg(OH)₂", "H₂"));
        reactionsList.add(new InitList("H₂O", "Ca", "Nothing", "Ca(OH)₂", "H₂"));
        reactionsList.add(new InitList("H₂O", "Sr", "Nothing", "Sr(OH)₂", "H₂"));
        reactionsList.add(new InitList("H₂O", "Ba", "Nothing", "Ba(OH)₂", "H₂"));

        // TODO CuOH, FeOH, ZnOH, AlOH

        reactionsList.add(new InitList("Li₂O", "H₂O", "Nothing", "LiOH"));
        reactionsList.add(new InitList("Na₂O", "H₂O", "Nothing", "NaOH"));
        reactionsList.add(new InitList("K₂O", "H₂O", "Nothing", "KOH"));
        reactionsList.add(new InitList("BeO", "H₂O", "Nothing", "Be(OH)₂"));
        reactionsList.add(new InitList("MgO", "H₂O", "Nothing", "Mg(OH)₂"));
        reactionsList.add(new InitList("CaO", "H₂O", "Nothing", "Ca(OH)₂"));
        reactionsList.add(new InitList("SrO", "H₂O", "Nothing", "Sr(OH)₂"));
        reactionsList.add(new InitList("BaO", "H₂O", "Nothing", "Ba(OH)₂"));

        //////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////

        reactionsList.add(new InitList("HCl", "NaOH", "Nothing", "H₂O", "NaCl"));
        reactionsList.add(new InitList("Cl₂", "Na", "Nothing", "NaCl"));

//        reactionsList.add(new InitList("", "", "", ""));
//        reactionsList.add(new InitList("", "", "", ""));

        //// 1111111111111111111111111111111
        //// ₂222222222222222222222222222222
        //// ₃₃₃₃333333333333333333333333333
        //// ₄444444444444444444444444444444
        //// ₅₅55555555555555555555555555555
        //// 6666666666666666666666666666666
        //// 7777777777777777777777777777777
    }

    public static List<String> getResult (String element_1, String element_2, String catalyst) {
        if (element_1.equals(element_2)) {
            return null;
        }
        for (int i = 0;i < reactionsList.size();i++) {
            InitList list = (InitList) reactionsList.get(i);
            if (list.size() != 3) {
                continue;
            }
            if (list.contains(element_1) && list.contains(element_2) && list.contains(catalyst)) {
                return list.result;
            }
        }
        return null;
    }

    public static List<String> getResult (String element_1, String catalyst) {
        for (int i = 0;i < reactionsList.size();i++) {
            InitList list = (InitList) reactionsList.get(i);
            if (list.size() != 2) {
                continue;
            }
            if (list.contains(element_1) && list.contains(catalyst)) {
                return list.result;
            }
        }
        return null;
    }


}
