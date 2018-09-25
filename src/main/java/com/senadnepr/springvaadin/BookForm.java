package com.senadnepr.springvaadin;

import com.senadnepr.springvaadin.Entity.Book;
import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

@SpringUI
public class BookForm extends FormLayout {

    private TextField title = new TextField("Название");
    private TextField description = new TextField("Описание");
    private TextField autor = new TextField("Автор");
    private TextField isbn = new TextField("ISBN");
    private TextField printYear = new TextField("Год издания");

    private CheckBox readAlready = new CheckBox("Прочитано");

    private Binder<Book> binder = new Binder<>(Book.class);


    private Button save = new Button("Сохранить");
    private Button delete = new Button("Удалить");
    private Button edit = new Button("Редактировать");
    private Button readCheck = new Button("Отметить прочитанной");


    private Book book;
    private MyUI myUI;

    public BookForm(MyUI myUI) {

        this.myUI = myUI;
        binder.forField(printYear).bind(
                book -> Integer.toString(book.getPrintYear()),
                (book, formValue) -> book.setPrintYear((Integer.valueOf(formValue)))
        );
        binder.bindInstanceFields(this);

        title.setWidth(300, Unit.PIXELS);
        description.setWidth(300, Unit.PIXELS);
        autor.setWidth(300, Unit.PIXELS);
        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        save.addClickListener(e -> this.save());
        delete.addClickListener(e -> this.delete());
        edit.addClickListener(e -> this.edit());
        readCheck.addClickListener(e -> this.readCheckOn());


        setSizeUndefined();
        VerticalLayout buttons = new VerticalLayout(save, delete, edit, readCheck);

        VerticalLayout textFieldLeft = new VerticalLayout(title, description, autor);

        VerticalLayout textFieldRight = new VerticalLayout(isbn, printYear, readAlready);
        HorizontalLayout textFields = new HorizontalLayout(textFieldLeft, textFieldRight, buttons);

        addComponent(textFields);
    }

     public void setBook(Book book) {
        this.book = book;
        binder.setBean(book);

        delete.setVisible(true);
        edit.setVisible(true);
        if(book.isReadAlready()) readCheck.setVisible(false);
        else readCheck.setVisible(true);
        save.setVisible(false);

        title.setReadOnly(true);
        description.setReadOnly(true);
        autor.setReadOnly(true);
        isbn.setReadOnly(true);
        printYear.setReadOnly(true);
        readAlready.setReadOnly(true);
        setVisible(true);
    }

    private void readCheckOn() {
        book.setReadAlready(true);
        this.save();
        setVisible(false);
    }

    private void delete() {
        myUI.delete(book);
        myUI.updateList();
        setVisible(false);
    }

    private void save() {

        myUI.save(book);
        myUI.updateList();
        setVisible(false);
    }

    private void edit() {
        save.setVisible(true);
        delete.setVisible(false);
        edit.setVisible(false);
        readCheck.setVisible(false);

        title.setReadOnly(false);
        description.setReadOnly(false);
        isbn.setReadOnly(false);
        printYear.setReadOnly(false);

        book.setReadAlready(false);
        readAlready.setReadOnly(true);
        setVisible(true);
        title.selectAll();
    }


    public void editNewBook(Book book) {
        this.book = book;
        binder.setBean(book);

        delete.setVisible(false);
        edit.setVisible(false);
        readCheck.setVisible(false);
        save.setVisible(true);

        title.setReadOnly(false);
        description.setReadOnly(false);
        autor.setReadOnly(false);
        isbn.setReadOnly(false);
        printYear.setReadOnly(false);


        book.setReadAlready(false);
        readAlready.setReadOnly(true);
        setVisible(true);
        title.selectAll();
    }
}
