package org.annabelle.domain;

import java.util.List;
import java.util.Map;

public interface Reportable {
    Map<Item.ItemStatus, List<Item>> generateReport(Library library);
}
