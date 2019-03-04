package omid.spring.example.springexample.apachepoi_example;

import java.util.List;

public class Patient {
    Integer id; //ردیف
    Long receptionNumber; //	 شماره پذیرش
    String patientName; // نام بیمار
    String patientFamily; //  نام خانوادگی
    Integer age; //سن
    String phoneCell; //موبایل
    String nationalCode; // کد ملی
    String dateRecept; // 	 تاریخ پذیرش
    String doktorCode; //  نظام پزشکی
    Long price; //  قیمت
    String exprementName; //  نام آزمایش
    String response; //  جواب
    String pain; //  نرمال رنج
    String unit; //  واحد
    String part; //  بخش

    public Patient() {
    }

    public Patient(Integer id, Long receptionNumber, String patientName, String patientFamily, Integer age, String phoneCell, String nationalCode, String dateRecept, String doktorCode, Long price, String exprementName, String response, String pain, String unit, String part) {
        this.id = id;
        this.receptionNumber = receptionNumber;
        this.patientName = patientName;
        this.patientFamily = patientFamily;
        this.age = age;
        this.phoneCell = phoneCell;
        this.nationalCode = nationalCode;
        this.dateRecept = dateRecept;
        this.doktorCode = doktorCode;
        this.price = price;
        this.exprementName = exprementName;
        this.response = response;
        this.pain = pain;
        this.unit = unit;
        this.part = part;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getReceptionNumber() {
        return receptionNumber;
    }

    public void setReceptionNumber(Long receptionNumber) {
        this.receptionNumber = receptionNumber;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientFamily() {
        return patientFamily;
    }

    public void setPatientFamily(String patientFamily) {
        this.patientFamily = patientFamily;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneCell() {
        return phoneCell;
    }

    public void setPhoneCell(String phoneCell) {
        this.phoneCell = phoneCell;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getDateRecept() {
        return dateRecept;
    }

    public void setDateRecept(String dateRecept) {
        this.dateRecept = dateRecept;
    }

    public String getDoktorCode() {
        return doktorCode;
    }

    public void setDoktorCode(String doktorCode) {
        this.doktorCode = doktorCode;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getExprementName() {
        return exprementName;
    }

    public void setExprementName(String exprementName) {
        this.exprementName = exprementName;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getPain() {
        return pain;
    }

    public void setPain(String pain) {
        this.pain = pain;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", receptionNumber=" + receptionNumber +
                ", patientName='" + patientName + '\'' +
                ", patientFamily='" + patientFamily + '\'' +
                ", age=" + age +
                ", phoneCell='" + phoneCell + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", dateRecept='" + dateRecept + '\'' +
                ", doktorCode='" + doktorCode + '\'' +
                ", price=" + price +
                ", exprementName='" + exprementName + '\'' +
                ", response='" + response + '\'' +
                ", pain='" + pain + '\'' +
                ", unit='" + unit + '\'' +
                ", part='" + part + '\'' +
                '}';
    }

    /**
     *  This method used to print list of patients
     * @param list
     */
    public static void printPatients(List<Patient> list){
        for (Patient p : list) {
            System.out.println(p.toString());
        }
    }
}
