package com.example.helloworldironmen;

import java.util.ArrayList;
import java.util.List;

public class HomeDataModel{
    public static List<HomeModel> groceryList() {
        HomeModel batik_sumatera = new HomeModel("batik sumatera", 10, "https://fitshop-production.s3.ap-southeast-1.amazonaws.com/wp-content/uploads/2020/04/20202149/Telur-Ayam.jpg");
        HomeModel  batik_jawa = new HomeModel("batik jawa", 2, "https://akcdn.detik.net.id/visual/2020/07/24/ilustrasi-sabun-batangan-1_169.jpeg?w=650");
        HomeModel batik_kalimantan = new HomeModel("batik kalimantan", 5, "https://ichef.bbci.co.uk/news/640/cpsprodpb/4D0C/production/_103642791_41843a55-c79b-4955-9c4b-16685f1f3f61.jpg");
        HomeModel batik_sulawesi = new HomeModel("batik sulawesi", 2, "https://static.republika.co.id/uploads/images/inpicture_slide/secangkir-teh-_190524103045-721.jpg");

        List<HomeModel> groceryList = new ArrayList<>();

        groceryList.add(batik_sumatera);
        groceryList.add(batik_jawa);
        groceryList.add(batik_kalimantan);
        groceryList.add(batik_sulawesi);

        return groceryList;
    }
}
