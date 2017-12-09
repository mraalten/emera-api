package nl.aalten.emera.api.twitter.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class MemberShould {

    @Test
    public void returnFalseBecauseItsNotHisBirthday() {
        Member member = new Member("A", "01-01-1970", "a.jpg");
        assertThat(member.isBirthday()).isFalse();
    }

    @Test
    public void returnTrueBecauseItsHisBirthday() {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String nowAsString = df.format(now);
        Member member = new Member("A", nowAsString, "a.jpg");
        assertThat(member.isBirthday()).isTrue();
    }
}
