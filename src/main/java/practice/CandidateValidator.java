package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE = 35;
    private static final int LIVING_PERIOD = 10;
    private static final String NATION = "Ukrainian";

    @Override
    public boolean test(Candidate c) {
        if (c.getAge() < AGE) {
            return false;
        }
        if (!NATION.equals(c.getNationality())) {
            return false;
        }
        if (!c.isAllowedToVote()) {
            return false;
        }

        String[] years = c.getPeriodsInUkr().split("-");
        int start = Integer.parseInt(years[0]);
        int end = Integer.parseInt(years[1]);
        return (end - start) >= LIVING_PERIOD;
    }
}
