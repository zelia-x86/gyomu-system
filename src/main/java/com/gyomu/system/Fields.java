package com.gyomu.system;

import com.gyomu.system.Database.InnerField;
import com.gyomu.system.Database.TextField;
import com.gyomu.system.Database.CheckBoxField;
import com.gyomu.system.Database.RadioButtonField;
import com.gyomu.system.Database.SelectField;

public class Fields {

    private InnerField seihin;
    private InnerField shouhin;
    private InnerField shinaban;
    private InnerField shinamei;
    private InnerField suuryo;

    private InnerField chk1;
    private InnerField chk2;
    private InnerField radio;
    private InnerField select;

    public Fields() {
        this.seihin = new TextField();
        this.shouhin = new TextField();
        this.shinaban = new TextField();
        this.shinamei = new TextField();
        this.suuryo = new TextField();

        this.chk1 = new CheckBoxField();
        this.chk2 = new CheckBoxField();
        this.radio = new RadioButtonField();
        this.select = new SelectField(new String[]{"Option 1", "Option 2", "Option 3"});
    }

    // Getter
    public InnerField getSeihin() { return seihin; }
    public InnerField getShouhin() { return shouhin; }
    public InnerField getShinaban() { return shinaban; }
    public InnerField getShinamei() { return shinamei; }
    public InnerField getSuuryo() { return suuryo; }

    public InnerField getChk1() { return chk1; }
    public InnerField getChk2() { return chk2; }
    public InnerField getRadio() { return radio; }
    public InnerField getSelect() { return select; }
}
