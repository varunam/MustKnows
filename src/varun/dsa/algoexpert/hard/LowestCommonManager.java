package varun.dsa.algoexpert.hard;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Lowest Common Manager
 * You're given three inputs, all of which are instances of an OrgChart class that have a directReports property
 * pointing to their direct reports. The first input is the top manager in an organizational chart (i.e., the only
 * instance that isn't anybody else's direct report), and the other two inputs are reports in the organizational chart.
 * The two reports are guaranteed to be distinct.
 * Write a function that returns the lowest common manager to the two reports.
 *
 * Sample Input
 * // From the organizational chart below.
 * topManager = Node A
 * reportOne = Node E
 * reportTwo = Node I
 *
 * Time Complexity: O(n)
 * Space Complexity: O(d)
 *
 * Problem Link: https://www.algoexpert.io/questions/Lowest%20Common%20Manager
 */
public class LowestCommonManager {

    public static void main(String[] args) {
        OrgChart orgChart = new OrgChart('A');
        OrgChart b = new OrgChart('B');
        OrgChart c = new OrgChart('C');
        orgChart.addDirectReports(new OrgChart[]{b, c});
        OrgChart d = new OrgChart('D');
        OrgChart e = new OrgChart('E');
        b.addDirectReports(new OrgChart[]{d, e});
        OrgChart f = new OrgChart('F');
        OrgChart g = new OrgChart('G');
        c.addDirectReports(new OrgChart[]{f, g});
        OrgChart h = new OrgChart('H');
        OrgChart i = new OrgChart('I');
        d.addDirectReports(new OrgChart[]{h, i});

        OrgChart lowestManager = getLowestCommonManager(orgChart, e, i);
        System.out.println("LowestManager: " + lowestManager.name);
    }

    public static OrgChart getLowestCommonManager(
            OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        return getOrgInfo(topManager, reportOne, reportTwo).lowestCommonManager;
    }

    public static OrgChartInfo getOrgInfo(OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {
        int numImportantReports = 0;
        for (OrgChart directReport : manager.directReports) {
            OrgChartInfo info = getOrgInfo(directReport, reportOne, reportTwo);
            if (info.lowestCommonManager != null) return info;
            numImportantReports += info.numImportantReports;
        }

        if (manager == reportOne || manager == reportTwo) numImportantReports++;
        OrgChart lowestCommonManager = numImportantReports == 2 ? manager : null;
        OrgChartInfo info = new OrgChartInfo(lowestCommonManager, numImportantReports);
        return info;
    }

    static class OrgChartInfo {
        public OrgChart lowestCommonManager;
        int numImportantReports;

        OrgChartInfo(OrgChart lowestCommonManager, int numImportantReports) {
            this.lowestCommonManager = lowestCommonManager;
            this.numImportantReports = numImportantReports;
        }
    }

    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<OrgChart>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }
    }
}
