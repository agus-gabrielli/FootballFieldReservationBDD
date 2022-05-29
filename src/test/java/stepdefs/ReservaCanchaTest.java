package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.fiuba.exceptions.ClosedFieldException;
import org.fiuba.exceptions.ExcessOfReservationTimeException;
import org.fiuba.exceptions.OccupiedFieldException;
import org.fiuba.FootballFieldSchedule;

import static org.junit.Assert.*;

public class ReservaCanchaTest {

    private FootballFieldSchedule fieldSchedule;
    private ClosedFieldException cfe;
    private ExcessOfReservationTimeException erte;
    private OccupiedFieldException ofe;

/*    @Before
    public void setup() {
        System.out.println("Before any test execution");
    }*/

    @Given("^the field is free from (\\d+) to (\\d+)$")
    public void the_field_is_free_from_to(int startingHour, int finishingHour) throws Throwable {
        fieldSchedule = new FootballFieldSchedule(8, 22);
    }

    @When("^trying to reserve from (\\d+) to (\\d+)$")
    public void trying_to_reserve_from_to(int startingHour, int finishingHour) throws Throwable {
        try{
            fieldSchedule.reserveField(startingHour, finishingHour, "Agustin");
        } catch (OccupiedFieldException ofe) {
            this.ofe = ofe;
        } catch (ExcessOfReservationTimeException erte) {
            this.erte = erte;
        } catch (ClosedFieldException cfe) {
            this.cfe = cfe;
        }
    }

    @Then("^reservation is denied due to occupied field$")
    public void reservation_is_denied_due_to_occupied_field() throws Throwable {
        assertNotNull(ofe);
    }

    @Given("^the field is open from (\\d+) to (\\d+)$")
    public void the_field_is_open_from_to(int openingHour, int closingHour) throws Throwable {
        fieldSchedule = new FootballFieldSchedule(openingHour, closingHour);
    }

    @Then("^reservation is denied due to closed field$")
    public void reservation_is_denied_due_to_closed_field() throws Throwable {
        assertNotNull(cfe);
    }

    @Then("^reservation is denied due to excess of reservation time$")
    public void reservation_is_denied_due_to_excess_of_reservation_time() throws Throwable {
        assertNotNull(erte);
    }

    @When("^\"([^\"]*)\" tries to reserve from (\\d+) to (\\d+)$")
    public void triesToReserveFromTo(String name, int startingHour, int finishingHour) throws Throwable {
        try{
            fieldSchedule.reserveField(startingHour, finishingHour, "Agustin");
        } catch (OccupiedFieldException ofe) {
            this.ofe = ofe;
        } catch (ExcessOfReservationTimeException erte) {
            this.erte = erte;
        } catch (ClosedFieldException cfe) {
            this.cfe = cfe;
        }
    }

    @Given("^the field is reserved from (\\d+) to (\\d+) by \"([^\"]*)\"$")
    public void theFieldIsReservedFromToBy(int startingHour, int finishingHour, String name) throws Throwable {
        fieldSchedule = new FootballFieldSchedule(8, 22);
        fieldSchedule.reserveField(startingHour, finishingHour, name);
    }

    @Then("^reservation is made from (\\d+) to (\\d+) by \"([^\"]*)\"$")
    public void reservationIsMadeFromToBy(int startingHour, int finishingHour, String name) throws Throwable {
        assertFalse(fieldSchedule.isFieldFree(startingHour,finishingHour));
        assertEquals(name, fieldSchedule.periodIsReservedBy(startingHour));
    }

    @And("^period from (\\d+) to (\\d+) should remain reserved by \"([^\"]*)\"$")
    public void periodFromToShouldRemainReservedBy(int startingHour, int finishingHour, String name) throws Throwable {
        assertFalse(fieldSchedule.isFieldFree(startingHour,finishingHour));
        assertEquals(name, fieldSchedule.periodIsReservedBy(startingHour));
    }

    /*@After
    public void tearDown() {
        System.out.println("After all test execution");
    }*/
}
