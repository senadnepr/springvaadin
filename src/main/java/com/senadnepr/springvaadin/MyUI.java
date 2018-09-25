package com.senadnepr.springvaadin;

import com.senadnepr.springvaadin.Controller.BookController;
import com.senadnepr.springvaadin.Entity.Book;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.shared.ui.grid.HeightMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@SpringUI
public class MyUI extends UI {



    private Grid<Book> grid = new Grid<>(Book.class);
    private int pageNumber = 0;
    private int pageSize = 10;

    @Autowired
    BookController bookController;
    private TextField filterText = new TextField();
    private BookForm form = new BookForm(this);
    Button prevPage = new Button(VaadinIcons.ANGLE_DOUBLE_LEFT);
    Button postPage = new Button(VaadinIcons.ANGLE_DOUBLE_RIGHT);


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();

        filterText.setPlaceholder("фильтр по названию, авторам и прочим колонкам ...");
        filterText.addValueChangeListener(e -> updateList());
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.setWidth(500, Unit.PIXELS);

        Button clearFilterTextBtn = new Button(VaadinIcons.CLOSE);
        clearFilterTextBtn.setDescription("Очистить фильтр");
        clearFilterTextBtn.addClickListener(e -> filterText.clear());

        CssLayout filtering = new CssLayout();
        filtering.addComponents(filterText, clearFilterTextBtn);
        filtering.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

        Button addBookBtn = new Button("Добавить книгу");
        addBookBtn.addClickListener(e -> {
            grid.asSingleSelect().clear();
            form.editNewBook(new Book());
        });

        prevPage.addClickListener(e ->{
            pageNumber--;
            updateList();
        });
        postPage.addClickListener(e ->{
            pageNumber++;
            updateList();
        });
        Label pageLabel = new Label("Страницы");


        HorizontalLayout toolbar = new HorizontalLayout(filtering, addBookBtn, pageLabel, prevPage, postPage);

        grid.setColumns("id", "title", "description", "autor", "isbn", "printYear");
        grid.setWidth(100, Unit.PERCENTAGE);
        grid.getColumn("title").setCaption("Название").setWidth(300);
        grid.getColumn("description").setCaption("Описание").setWidth(300);
        grid.getColumn("autor").setCaption("Автор").setWidth(300);
        grid.getColumn("isbn").setCaption("ISBN").setWidth(180);
        grid.getColumn("printYear").setCaption("Год печати").setWidth(120);


        grid.addComponentColumn(book -> {CheckBox box = new CheckBox();
            box.setValue(book.isReadAlready());
            box.setReadOnly(true);
            return box;
        }).setCaption("Прочитано").setWidth(120);

        updateList();
        form.setVisible(false);
        grid.setHeightMode(HeightMode.UNDEFINED);

        layout.addComponents(toolbar, grid, form);

        setContent(layout);

        grid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() == null) {
                form.setVisible(false);
            } else {
                form.setBook(event.getValue());
            }
        });
    }

    public void updateList() {


        List<Book> books = bookController.getAllBook(filterText.getValue());
        int pageNumbers = (int) Math.ceil((float)books.size() / pageSize);

        if(pageNumber == 0) prevPage.setVisible(false);
        else prevPage.setVisible(true);

        if(pageNumber + 1 >= pageNumbers)  postPage.setVisible(false);
        else postPage.setVisible(true);

        ArrayList<Book> page = new ArrayList<>();
        int fromIndex;
        int toIndex;
        if(pageNumbers == 0) pageNumber = 0;
        else if(pageNumber > pageNumbers - 1) pageNumber = pageNumbers - 1;
        fromIndex = pageNumber * pageSize;
        if((pageNumber + 1) * pageSize >= books.size()){
            toIndex = books.size();
        }
        else toIndex = fromIndex + pageSize;

        page.addAll(books.subList(fromIndex, toIndex));

        grid.setItems(page);
    }

    public void delete(Book book) {
        bookController.delete(book);
    }

    public void save(Book book) {
        bookController.save(book);
    }

}