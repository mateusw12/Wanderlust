package com.wanderlust.wanderlust.external.hotel.airBnb.model.category;

public enum AirBnbCategoryIdEnum {

    AR_SA("ar-SA", "Arabic (Saudi Arabia)"),
    ZH_CN("zh-CN", "Chinese (China)"),
    ZH_HK("zh-HK", "Chinese (Hong Kong SAR China)"),
    ZH_TW("zh-TW", "Chinese (Taiwan)"),
    CS_CZ("cs-CZ", "Czech (Czech Republic)"),
    DA_DK("da-DK", "Danish (Denmark)"),
    NL_BE("nl-BE", "Dutch (Belgium)"),
    NL_NL("nl-NL", "Dutch (Netherlands)"),
    EN_AU("en-AU", "English (Australia)"),
    EN_IE("en-IE", "English (Ireland)"),
    EN_ZA("en-ZA", "English (South Africa)"),
    EN_GB("en-GB", "English (United Kingdom)"),
    EN_US("en-US", "English (United States)"),
    FI_FI("fi-FI", "Finnish (Finland)"),
    FR_CA("fr-CA", "French (Canada)"),
    FR_FR("fr-FR", "French (France)"),
    DE_DE("de-DE", "German (Germany)"),
    EL_GR("el-GR", "Greek (Greece)"),
    HE_IL("he-IL", "Hebrew (Israel)"),
    HI_IN("hi-IN", "Hindi (India)"),
    HU_HU("hu-HU", "Hungarian (Hungary)"),
    ID_ID("id-ID", "Indonesian (Indonesia)"),
    IT_IT("it-IT", "Italian (Italy)"),
    JA_JP("ja-JP", "Japanese (Japan)"),
    KO_KR("ko-KR", "Korean (South Korea)"),
    NO_NO("no-NO", "Norwegian (Norway)"),
    PL_PL("pl-PL", "Polish (Poland)"),
    PT_BR("pt-BR", "Portuguese (Brazil)"),
    PT_PT("pt-PT", "Portuguese (Portugal)"),
    RO_RO("ro-RO", "Romanian (Romania)"),
    RU_RU("ru-RU", "Russian (Russia)"),
    SK_SK("sk-SK", "Slovak (Slovakia)"),
    ES_MX("es-MX", "Spanish (Mexico)"),
    ES_ES("es-ES", "Spanish (Spain)"),
    SV_SE("sv-SE", "Swedish (Sweden)"),
    TH_TH("th-TH", "Thai (Thailand)"),
    TR_TR("tr-TR", "Turkish (Turkey)");

    private final String id;
    private final String title;

    private AirBnbCategoryIdEnum(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}
