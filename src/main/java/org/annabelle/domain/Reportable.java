package org.annabelle.domain;

public interface Reportable {
    /**
     * Generates a full report of the system
     * @return report as a String
     */
    String generateReport();
}
