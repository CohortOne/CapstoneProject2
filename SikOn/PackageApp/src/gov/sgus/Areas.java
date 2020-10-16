/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.sgus;

/**
 *
 * @author deng
 */
    public enum Areas {
        AlorSetar("4", 60),   //+60423234  60 sen  per minute
        Ampang("3", 70),
        BatuPahat("7", 30),
        Bintulu("86", 14),
        BukitMertajam("4", 60),
        Butterworth("4", 60),
        Chukai("9", 10),
        GeorgeTown("4", 60),
        Ipoh("5", 50),
        JohorBahru("7", 30),
        Kajang("3", 70),
        Klang("3", 70),
        Kluang("7", 30),
        KotaBahru("9", 10),
        KotaKinabalu("88", 12),
        KualaLumpur("3", 70),
        KualaTerengganu("9", 10),
        Kuantan("9", 10),
        Kuching("82", 18),
        Kulim("4", 60),
        LahadDatu("89", 11),
        Malacca("6", 40),
        Miri("85", 15),
        Muar("6", 40),
        PasirGudang("7", 30),
        PetalingJaya("3", 70),
        PortDickson("6", 40),
        Rawang("3", 70),
        Sandakan("89", 11),
        Selayang("3", 70),
        Seremban("6", 40),
        ShahAlam("3", 70),
        Sibu("84", 16),
        SubangJaya("3", 70),
        SungaiAra("4", 60),
        SungaiPetani("4", 60),
        Taiping("5", 50),
        Tawau("89", 11),
        TelukIntan("5", 50);

        String areaCode;
        int callRate;

        Areas(String const1, int const2) {
            areaCode = const1;
            callRate = const2;
        }

        public String getAreaCode() {
            return this.areaCode;
        }

        public int getCallRate() {
            return this.callRate;
        }
        
        
    
    public static Areas findArea(String strTel) {  // given a phone number, get the Area
        String strTmp;
        Areas myArea = null;
        strTmp = strTel.substring(3,5);   // +6035  35 3 
        for (Areas myVal : Areas.values()) {
            if (myVal.getAreaCode().equals(strTmp)) {
                myArea = myVal;
                break;
            }
        }

        if (myArea == null) {
            strTmp = strTel.substring(3,4);
            for (Areas myVal : Areas.values()) {
                if (myVal.getAreaCode().equals(strTmp)) {
                    myArea = myVal;
                    break;
                }
            }
        }
        return myArea;
    }

        
    }        
