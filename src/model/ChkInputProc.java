package model;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChkInputProc {

    public String chkEmail(String email){
        String errorMsg="";
        errorMsg=email.isEmpty()?"e-mailが空です。\n":errorMsg;

        Pattern p = Pattern.compile("^(([0-9a-zA-Z!#\\$%&'\\*\\+\\-/=\\?\\^_`\\{\\}\\|~]+(\\.[0-9a-zA-Z!#\\$%&'\\*\\+\\-/=\\?\\^_`\\{\\}\\|~]+)*)|(\"[^\"]*\"))"
                        + "@[0-9a-zA-Z!#\\$%&'\\*\\+\\-/=\\?\\^_`\\{\\}\\|~]+"
                        + "(\\.[0-9a-zA-Z!#\\$%&'\\*\\+\\-/=\\?\\^_`\\{\\}\\|~]+)*$");

        Matcher m = p.matcher(email);
        errorMsg+=(!m.find())?"e-mailの形式が正しくありません\n":"";

        return errorMsg;
    }


    public String chkTel(String tel){
        String errorMsg="";
        errorMsg=tel.isEmpty()?"電話番号が空です。\n":errorMsg;

        Pattern p = Pattern.compile("0\\d{1,4}-\\d{1,4}-\\d{4}");


        Matcher m = p.matcher(tel);
        errorMsg+=(!m.find())?"電話番号の形式が正しくありません。(例:03-5259-0070)\n":"";

        return errorMsg;
    }


    public String chkL_name(String l_name){
        String errorMsg="";
        String MATCH_ZENKAKU = "^[ぁ-んァ-ヶー一-龠]+$";
        errorMsg=l_name.isEmpty()?"(氏)が空です。\n":errorMsg;
        errorMsg=(!l_name.matches(MATCH_ZENKAKU))?"(氏)が全角ではありません。\n":"";

        return errorMsg;
    }


    public String chkF_name(String f_name){
        String errorMsg="";
        String MATCH_ZENKAKU = "^[ぁ-んァ-ヶー一-龠]+$";
        f_name=trimString(f_name);
        errorMsg=f_name.isEmpty()?"(名)が空です。\n":errorMsg;
        errorMsg=(!f_name.matches(MATCH_ZENKAKU))?"(名)が全角ではありません。\n":"";

        return errorMsg;
    }


    public String chkL_name_kana(String l_name_kana){
        String errorMsg="";
        l_name_kana=trimString(l_name_kana);
        String MATCH_KATAKANA = "^[\\u30A0-\\u30FF]+$";

        errorMsg=l_name_kana.isEmpty()?"(シ)が空です。\n":errorMsg;
        errorMsg=(!l_name_kana.matches(MATCH_KATAKANA))?"(シ)が全角カナでありません。\n":"";


        return errorMsg;
    }


    public String chkF_name_kana(String f_name_kana){
        String errorMsg="";
        String MATCH_KATAKANA = "^[\\u30A0-\\u30FF]+$";

        errorMsg=f_name_kana.isEmpty()?"(メイ)が空です。\n":errorMsg;
        errorMsg=(!f_name_kana.matches(MATCH_KATAKANA))?"(メイ)が全角カナでありません。\n":"";



        return errorMsg;
    }


    public String chkPassword(String password){
        String errorMsg="";
        password=trimString(password);
        errorMsg=password.isEmpty()?"パスワードが空です。\n":errorMsg;

        return errorMsg;
    }


    public String chkPrefecture(String prefecture){
        String errorMsg="";
        prefecture=trimString(prefecture);
        errorMsg=prefecture.isEmpty()?"都道府県が選択されていません。\n":errorMsg;


        return errorMsg;
    }

    public String chkCity(String city){
        String errorMsg="";
        city=trimString(city);
        String MATCH_ZENKAKU = "^[ぁ-んァ-ヶー一-龠]+$";
        errorMsg=city.isEmpty()?"市区町村が空です。\n":errorMsg;
        errorMsg=(!city.matches(MATCH_ZENKAKU))?"市区町村が全角でありません。\n":"";


        return errorMsg;
    }

    public String chkO_address(String o_address){
        String errorMsg="";
        o_address=trimString(o_address);
        errorMsg=o_address.isEmpty()?"番地・建物・号室が空です。\n":errorMsg;


        return errorMsg;
    }


    public String trimString(String str) {
        str = str.replaceAll(" ", ""); //全角スペースを半角に
        str=str.trim();

        return str;
    }


}
