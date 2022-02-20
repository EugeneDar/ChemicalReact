package com.barbar.chemicalreact;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Substances {

    // ₀₁₂₃₄₅₆₇₈₉

    public static List<String> listSimpleElements = new ArrayList<>();
    public static List<String> listOxides = new ArrayList<>();

    public static void initialize () {
        listSimpleElements.addAll(Arrays.asList(
                "H₂", "O₂", "Na", "Li", "K", "Be", "Mg", "Ca")
        );
        listOxides.addAll(Arrays.asList(
                "Na₂O", "Li₂O", "K₂O", "BeO", "MgO", "CaO"
        ));
    }


}
