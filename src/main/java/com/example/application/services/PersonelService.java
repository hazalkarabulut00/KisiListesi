package com.example.application.services;

import com.example.application.models.Personel;

import java.util.*;

public class PersonelService {

    private static final Map<Long, Personel> PERSONELS = new HashMap<>();

    private static final String[] AD = new String[]{"Mesude", "Ahmet",
            "Ali", "Hatice", "Yadigar", "Melek", "Erdem", "Linda", "Orhan", "Mehmet"};

    private static final String[] SOYAD = new String[]{"Cihan",
            "Bedir", "Çelebi", "Karagöz", "Altın", "Akay", "Kara",
            "Battal", "Özdemir", "Kılıç" };

    private static final String[] TC = new String[]{"58445042642",
            "73151595534", "15952078502", "21726721604", "48839673828", "58262168266", "25653152470",
            "36500151348", "71444715676", "63880102738" };

    private static final Random random = new Random(1);

    static {
        long i = 0;

        for (i = 0; i < 10; i++) {
            String TC = getTC();
            String Ad = getAd();
            String Soyad = getSoyad();
            PERSONELS.put(i, new Personel(i, TC, Ad, Soyad));
        }
    }

    public static String getTC() {
        return TC[random.nextInt(TC.length)];
    }

    public static String getAd() {
        return AD[random.nextInt(AD.length)];
    }

    public static String getSoyad() {
        return SOYAD[random.nextInt(SOYAD.length)];
    }

    public static Collection<Personel> getPersonels() {
        return PERSONELS.values();
    }

    public static Personel getPersonel() {
        return PERSONELS.get(new ArrayList<>(PERSONELS.keySet())
                .get(random.nextInt(PERSONELS.size())));
    }
}
