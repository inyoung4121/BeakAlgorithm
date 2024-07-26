import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Applicant implements Comparable<Applicant> {
    int documentScore;
    int interviewScore;

    public Applicant(int documentScore, int interviewScore) {
        this.documentScore = documentScore;
        this.interviewScore = interviewScore;
    }

    @Override
    public int compareTo(Applicant other) {
        return Integer.compare(this.documentScore, other.documentScore);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCases; t++) {
            int applicantCount = Integer.parseInt(br.readLine());
            List<Applicant> applicants = new ArrayList<>();

            for (int i = 0; i < applicantCount; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int documentScore = Integer.parseInt(st.nextToken());
                int interviewScore = Integer.parseInt(st.nextToken());
                applicants.add(new Applicant(documentScore, interviewScore));
            }

            System.out.println(getNumberOfSuccessfulApplicants(applicants));
        }
    }

    private static int getNumberOfSuccessfulApplicants(List<Applicant> applicants) {
        Collections.sort(applicants);

        int minInterviewScore = Integer.MAX_VALUE;
        int successfulApplicants = 0;

        for (Applicant applicant : applicants) {
            if (applicant.interviewScore < minInterviewScore) {
                minInterviewScore = applicant.interviewScore;
                successfulApplicants++;
            }
        }

        return successfulApplicants;
    }
}
