package model;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class GenPrefectureSel {


    public GenPrefectureSel() {


    }

    public String GenPrefectureSelTag(String selected) {

        String prefectureTag="";
        boolean selFlg=false;

        String prefectureHeadTag1="<select name=\"prefecture\">\n<option value=\"\" selected>都道府県</option>\n";
        String prefectureHeadTag2="<select name=\"prefecture\">\n<option value=\"\">都道府県</option>\n";

        LinkedHashMap<String,String> hmpPrefecture= new LinkedHashMap<String,String>();
        hmpPrefecture=reHmpPrefecture();

        System.out.println(selected);

        for(HashMap.Entry<String, String> entry : hmpPrefecture.entrySet()) {
            if(entry.getKey().equals(selected)){
                prefectureTag +="<option value=\""+entry.getKey()+"\" selected>"+entry.getValue()+"</option>\n";
                selFlg=true;
            }else {
                prefectureTag +="<option value=\""+entry.getKey()+"\">"+entry.getValue()+"</option>\n";
            }

        }

        if(selFlg) {
            prefectureTag=prefectureHeadTag2+prefectureTag+"</select>";

        }else {
            prefectureTag=prefectureHeadTag1+prefectureTag+"</select>";
        }

        return prefectureTag;

    }



    private LinkedHashMap<String,String>  reHmpPrefecture() {
        LinkedHashMap<String,String> hmpPrefecture= new LinkedHashMap<String,String>();
        //hmpPrefecture.put("都道府県", "");
        hmpPrefecture.put("北海道","北海道");
        hmpPrefecture.put("青森県","青森県");
        hmpPrefecture.put("岩手県","岩手県");
        hmpPrefecture.put("宮城県","宮城県");
        hmpPrefecture.put("秋田県","秋田県");
        hmpPrefecture.put("山形県","山形県");
        hmpPrefecture.put("福島県","福島県");
        hmpPrefecture.put("茨城県","茨城県");
        hmpPrefecture.put("栃木県","栃木県");
        hmpPrefecture.put("群馬県","群馬県");
        hmpPrefecture.put("埼玉県","埼玉県");
        hmpPrefecture.put("千葉県","千葉県");
        hmpPrefecture.put("東京都","東京都");
        hmpPrefecture.put("神奈川県","神奈川県");
        hmpPrefecture.put("新潟県","新潟県");
        hmpPrefecture.put("富山県","富山県");
        hmpPrefecture.put("石川県","石川県");
        hmpPrefecture.put("福井県","福井県");
        hmpPrefecture.put("山梨県","山梨県");
        hmpPrefecture.put("長野県","長野県");
        hmpPrefecture.put("岐阜県","岐阜県");
        hmpPrefecture.put("静岡県","静岡県");
        hmpPrefecture.put("愛知県","愛知県");
        hmpPrefecture.put("三重県","三重県");
        hmpPrefecture.put("滋賀県","滋賀県");
        hmpPrefecture.put("京都府","京都府");
        hmpPrefecture.put("大阪府","大阪府");
        hmpPrefecture.put("兵庫県","兵庫県");
        hmpPrefecture.put("奈良県","奈良県");
        hmpPrefecture.put("和歌山県","和歌山県");
        hmpPrefecture.put("鳥取県","鳥取県");
        hmpPrefecture.put("島根県","島根県");
        hmpPrefecture.put("岡山県","岡山県");
        hmpPrefecture.put("広島県","広島県");
        hmpPrefecture.put("山口県","山口県");
        hmpPrefecture.put("徳島県","徳島県");
        hmpPrefecture.put("香川県","香川県");
        hmpPrefecture.put("愛媛県","愛媛県");
        hmpPrefecture.put("高知県","高知県");
        hmpPrefecture.put("福岡県","福岡県");
        hmpPrefecture.put("佐賀県","佐賀県");
        hmpPrefecture.put("長崎県","長崎県");
        hmpPrefecture.put("熊本県","熊本県");
        hmpPrefecture.put("大分県","大分県");
        hmpPrefecture.put("宮崎県","宮崎県");
        hmpPrefecture.put("鹿児島県","鹿児島県");
        hmpPrefecture.put("沖縄県","沖縄県");

        return hmpPrefecture;


    }




}
