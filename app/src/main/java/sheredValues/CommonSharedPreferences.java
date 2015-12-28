package sheredValues;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;

import model.Account;

/**
 * Created by arafla on 25/12/2015.
 */
public class CommonSharedPreferences {
    private static CommonSharedPreferences instance;
    private static SharedPreferences commonSharedPreferences;
    private static SharedPreferences.Editor editor;
    private final static String PREF_APP = "MyPrefs";
    private final static String FORMATION_LIST = "formationList";
    private final static String ACCOUNT = "account";
    private final static String CURRENT_FORMATION = "formationCourante";


    public static CommonSharedPreferences getInstance(Context context) {
        if (instance == null) {
            return new CommonSharedPreferences(context);
        }
        return instance;
    }

    private CommonSharedPreferences(Context context) {
        commonSharedPreferences = context.getSharedPreferences(PREF_APP, Context.MODE_PRIVATE);
        editor = commonSharedPreferences.edit();
    }

    public void setFormationList(ArrayList<String> formationList) {
        Gson gson = new Gson();
        String jsonFormationList = gson.toJson(formationList);
        editor.putString(FORMATION_LIST, jsonFormationList);
        editor.commit();
    }

    public void setCurrentFormation(String currentFormation) {
        editor.putString(CURRENT_FORMATION,currentFormation);
        editor.commit();
    }
    public String getCurrentFormation() {
        String formation=commonSharedPreferences.getString(CURRENT_FORMATION, null);
        return formation;
    }

    public void setAccount(Account account) {
        Gson gson = new Gson();
        String jsonAccount = gson.toJson(account);
        editor.putString(ACCOUNT, jsonAccount);
        editor.commit();
    }

    public Account getAccount() {
        String jsonAccount = commonSharedPreferences.getString(ACCOUNT, null);
        Gson gson = new Gson();
        Account account = gson.fromJson(jsonAccount, Account.class);
        return account;
    }

    public ArrayList getFormationList() {
        String jsonFormations = commonSharedPreferences.getString(FORMATION_LIST, null);
        Gson gson = new Gson();
        ArrayList<String> formationList = gson.fromJson(jsonFormations, ArrayList.class);
        return formationList;
    }
}
