package com.example.application.views.personel;

import com.example.application.models.Personel;
import com.example.application.services.PersonelService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.HeaderRow;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.regex.Pattern;

@PageTitle("Personel")
@Route(value = "personel", layout = MainLayout.class)
public class PersonelView extends HorizontalLayout {

    private Grid<Personel> grid;

    private ListDataProvider<Personel> dataProvider;

    private TextField firstNameFilter;

    public PersonelView() {

        grid = new Grid<>(Personel.class, false);
        dataProvider = DataProvider.ofCollection(PersonelService.getPersonels());
        grid.setDataProvider(dataProvider);
        grid.addColumn(Personel::getId)
                .setHeader("ID")
                .setAutoWidth(true)
                .setFlexGrow(0)
                .setFrozen(true)
                .setSortable(true);
        grid.addColumn(Personel::getAd).setKey("firstname").setHeader("AD");
        grid.addColumn(Personel::getSoyad).setHeader("SOYAD");

        HeaderRow headerRow = grid.appendHeaderRow();

        firstNameFilter = new TextField();

        firstNameFilter.setValueChangeMode(ValueChangeMode.TIMEOUT);
        firstNameFilter.addValueChangeListener(event -> this.onFirstNameFilterChange());
        firstNameFilter.setWidthFull();
        headerRow.getCell(grid.getColumnByKey("firstname")).setComponent(firstNameFilter);

        add(grid);
    }

    private void onFirstNameFilterChange(){
        dataProvider.setFilter(item -> {
            boolean firstNameFilterMatch = true;

            if(!firstNameFilter.isEmpty()){
                firstNameFilterMatch = Pattern.compile(Pattern.quote(firstNameFilter.getValue()), Pattern.CASE_INSENSITIVE).matcher(item.getAd()).find();
            }

            return firstNameFilterMatch;
        });
    }

    private void showDetails(Personel personel) {

    }
}
