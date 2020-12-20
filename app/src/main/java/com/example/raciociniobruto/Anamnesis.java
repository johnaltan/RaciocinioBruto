package com.example.raciociniobruto;

import java.util.HashMap;
import java.util.Set;

public class Anamnesis extends Stage{
    private String Name;
    private String Sex;
    private String Profession;
    private String CC; //QP
    private String HPI; //HDA
    private String ROS; //ISDAS
    private String PMH; //HMP
    private String FD; //HMF
    private String SH; //HFS


    public Anamnesis() {

    }

    public Anamnesis(String name) {
        Name = name;
    }

    public Anamnesis(String name, String sex, String profession, String CC, String HPI, String ROS, String PMH, String FD, String SH) {

        this.Name = name;
        this.Sex = sex;
        this.Profession = profession;
        this.CC = CC;
        this.HPI = HPI;
        this.ROS = ROS;
        this.PMH = PMH;
        this.FD = FD;
        this.SH = SH;
        super.info.put("Nome",this.Name);
        super.info.put("Sexo",this.Sex);
        super.info.put("Profissão", this.Profession);
        super.info.put("QP", this.CC);
        super.info.put("HDA", this.HPI);
        super.info.put("ISDAS",this.ROS);
        super.info.put("HMP",this.PMH);
        super.info.put("HMF",this.FD);
        super.info.put("HFS",this.SH);
    }




}
