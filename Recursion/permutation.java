package Recursion;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

public class permutation {

static ArrayList<String> Permutation_list(String p, String up){
    if (up.isEmpty()) {
       ArrayList<String> list = new ArrayList<>();
       list.add(p);
       return list;
   }
   char ch = up.charAt(0);
   ArrayList<String> ans = new ArrayList<>();
   for (int i = 0; i <= p.length(); i++) {
       String f = p.substring(0, i);
       String l = p.substring(i, p.length());
       ans.addAll(Permutation_list(f + ch + l, up.substring(1)));
   }
   return ans;
}
}