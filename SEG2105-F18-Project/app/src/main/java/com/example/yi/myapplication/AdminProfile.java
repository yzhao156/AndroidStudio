package com.example.yi.myapplication;

public class AdminProfile {


    public String username;



    public String password;

    public AdminProfile () {

    }

    public AdminProfile (String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) { this.password = password; }


    public void encryptPassword() {
        StringBuilder sb = new StringBuilder();
        char[] ch = password.toCharArray();
        for(int i = 0; i < ch.length; i++) {
            sb.append(Integer.valueOf(ch[i] + 5).intValue()).append(",");

        }
        password = sb.toString();
    }

//    public void decryptPassword() {
//        StringBuffer sbu = new StringBuffer();
//        String[] chars = password.split(",");
//        for (int i = 0; i < chars.length; i++) {
//            sbu.append((char) (Integer.parseInt(chars[i]) - 5));
//        }
//        password = sbu.toString();
//    }

//    public void encryptPassword() {
//        int temp;
//        char[] ch = password.toCharArray();
//        for(int i = 0; i < ch.length; i++) {
//            temp = (int)ch[i];
//            temp += 5;
//            ch[i] = (char)temp;
//        }
//        password = new String(ch);
//    }
}
