package nl.aalten.emera.api.twitter.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Member {
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    public final String name;
    public Date birthDate;
    public final String imageName;

    public Member(String name, String birthDate, String imageName) {
        this.name = name;
        try {
            this.birthDate = formatter.parse(birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.imageName = imageName;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getImageName() {
        return imageName;
    }

    public boolean hasImage() {
        return imageName != null && imageName.length() > 0;
    }

    public boolean isBirthday() {
        Date now = new Date();
        if (isEqual(birthDate, Calendar.DAY_OF_MONTH)) {
            return isEqual(birthDate, Calendar.MONTH);
        }
        return false;
    }

    private boolean isEqual(Date birthDate, int field) {
        Calendar calendarNow = Calendar.getInstance();
        calendarNow.setTime(new Date());

        Calendar calendarBirthdate = Calendar.getInstance();
        calendarBirthdate.setTime(birthDate);

        return calendarNow.get(field) == calendarBirthdate.get(field);
    }

    @Override
    public String toString() {
        return "Member{" + "name='" + name + '\'' + ", birthDate=" + birthDate + ", imageName='" + imageName + '\'' + '}';
    }
}
