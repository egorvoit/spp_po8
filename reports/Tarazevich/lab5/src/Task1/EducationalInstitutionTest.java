package Task1;

import java.util.ArrayList;
import java.util.List;

public class EducationalInstitutionTest {
    public static void main(String[] args) {
        List<EducationalInstitution> educationalInstitutions = new ArrayList<>();
        educationalInstitutions.add(new College("MuchosranksiyColledg",
                "Muchosranks, yl. Pushkina, dom Kolatychkina "));
        educationalInstitutions.add(new University("KrutoiUniversitet",
                "Paris, pod EefelevoiBachnei"));

        for (EducationalInstitution educationalInstitution : educationalInstitutions) {
            educationalInstitution.conductAdmissions();
        }
    }
}
