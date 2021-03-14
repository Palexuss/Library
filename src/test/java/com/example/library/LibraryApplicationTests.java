package com.example.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LibraryApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void creationBooksListTest() throws Exception {
        this.mockMvc.perform(get("/books/list")).
                andDo(print()).
                andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":1,\"title\":\"1984\",\"year\":1949,\"publishing\":\"Secker and Warburg\",\"authors\":" +
                        "[]},{\"id\":2,\"title\":\"Witcher\",\"year\":1986,\"publishing\":\"superNOWA\",\"authors\":[]},{\"id\":3,\"title\":" +
                        "\"The Lord of the Rings\",\"year\":1954,\"publishing\":\"George Allen & Unwin\",\"authors\":[]},{\"id\":4,\"title\":" +
                        "\"Harry Potter\",\"year\":1997,\"publishing\":\"Bloomsbury\",\"authors\":[]},{\"id\":5,\"title\":\"Thinking in Java\",\"year\":" +
                        "1998,\"publishing\":\"Prentice Hall\",\"authors\":[]},{\"id\":6,\"title\":\"Unnamed book\",\"year\":2021,\"publishing\":" +
                        "\"None\",\"authors\":[]}]")));
    }

    @Test
    public void findBooksByTitleTest() throws Exception {
        this.mockMvc.perform(get("/books/find-by-title/Witcher")).
                andDo(print()).
                andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":2,\"title\":\"Witcher\",\"year\":1986,\"publishing\":\"superNOWA\",\"authors\":[]}]")));
    }

    @Test
    public void findBooksByYearTest() throws Exception {
        this.mockMvc.perform(get("/books/find-by-year/1954")).
                andDo(print()).
                andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":3,\"title\":\"The Lord of the Rings\",\"year\":1954,\"publishing\":\"George Allen & Unwin\",\"authors\":[]}]")));
    }

    @Test
    public void findBooksByPublishingTest() throws Exception {
        this.mockMvc.perform(get("/books/find-by-publishing/superNOWA")).
                andDo(print()).
                andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":2,\"title\":\"Witcher\",\"year\":1986,\"publishing\":\"superNOWA\",\"authors\":[]}]")));
    }

    @Test
    public void findBooksByAuthorNameTest() throws Exception {
        this.mockMvc.perform(get("/books/find-by-name/john")).
                andDo(print()).
                andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":5,\"title\":\"Thinking in Java\",\"year\":1998,\"publishing\":\"Prentice Hall\",\"authors\":[]}]")));
    }

    @Test
    public void findBooksByAuthorYearTest() throws Exception {
        this.mockMvc.perform(get("/books/find-by-author-year/1965")).
                andDo(print()).
                andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":4,\"title\":\"Harry Potter\",\"year\":1997,\"publishing\":\"Bloomsbury\",\"authors\":[]}]")));
    }

    @Test
    public void findBooksByAuthorMonthTest() throws Exception {
        this.mockMvc.perform(get("/books/find-by-author-month/7")).
                andDo(print()).
                andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":4,\"title\":\"Harry Potter\",\"year\":1997,\"publishing\":\"Bloomsbury\",\"authors\":[]}" +
                        ",{\"id\":5,\"title\":\"Thinking in Java\",\"year\":1998,\"publishing\":\"Prentice Hall\",\"authors\":[]}]")));
    }

    @Test
    public void findBooksByAuthorDayTest() throws Exception {
        this.mockMvc.perform(get("/books/find-by-author-day/31")).
                andDo(print()).
                andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":4,\"title\":\"Harry Potter\",\"year\":1997,\"publishing\":\"Bloomsbury\",\"authors\":[]}]")));
    }

    @Test
    public void findBooksByAuthorFirstNameSymbolTest() throws Exception {
        this.mockMvc.perform(get("/books/find-by-first-name-symbol/J")).
                andDo(print()).
                andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":3,\"title\":\"The Lord of the Rings\",\"year\":1954,\"publishing\":\"George Allen & Unwin\"," +
                        "\"authors\":[]},{\"id\":4,\"title\":\"Harry Potter\",\"year\":1997,\"publishing\":\"Bloomsbury\",\"authors\":[]}]")));
    }

    @Test
    public void findBooksByAuthorFirstNameSymbolsTest() throws Exception {
        this.mockMvc.perform(get("/books/find-by-first-name-symbol/Joa")).
                andDo(print()).
                andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":4,\"title\":\"Harry Potter\",\"year\":1997,\"publishing\":\"Bloomsbury\",\"authors\":[]}]")));
    }

    @Test
    public void findBooksByAuthorFirstSurnameSymbolTest() throws Exception {
        this.mockMvc.perform(get("/books/find-by-first-surname-symbol/O")).
                andDo(print()).
                andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":1,\"title\":\"1984\",\"year\":1949,\"publishing\":\"Secker and Warburg\",\"authors\":[]}]")));
    }

    @Test
    public void findBooksByAuthorFirstSurnameSymbolsTest() throws Exception {
        this.mockMvc.perform(get("/books/find-by-first-surname-symbol/Tolk")).
                andDo(print()).
                andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":3,\"title\":\"The Lord of the Rings\",\"year\":1954,\"publishing\":\"George Allen & Unwin\",\"authors\":[]}]")));
    }

    @Test
    public void findBooksByIdTest() throws Exception {
        this.mockMvc.perform(get("/books/find-by-id/1")).
                andDo(print()).
                andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":1,\"title\":\"1984\",\"year\":1949,\"publishing\":\"Secker and Warburg\",\"authors\":[]}]")));
    }

    @Test
    public void findBooksByCorrectGenderTest() throws Exception {
        this.mockMvc.perform(get("/books/find-by-gender/Female")).
                andDo(print()).
                andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":4,\"title\":\"Harry Potter\",\"year\":1997,\"publishing\":\"Bloomsbury\",\"authors\":[]}]")));
    }

    @Test
    public void findBooksByWrongGenderTest() throws Exception {
        this.mockMvc.perform(get("/books/find-by-gender/esfhesfhkes")).
                andDo(print()).
                andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":6,\"title\":\"Unnamed book\",\"year\":2021,\"publishing\":\"None\",\"authors\":[]}]")));
    }

    @Test
    public void creationAuthorsListTest() throws Exception {
        this.mockMvc.perform(get("/authors/list")).
                andDo(print()).
                andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":1,\"name\":\"john\",\"surname\":\"Eckel\",\"day\":8,\"month\":7,\"year\":" +
                        "1957,\"gender\":null,\"books\":[]},{\"id\":2,\"name\":\"Andrzej\",\"surname\":\"Sapkowski\",\"day\":21,\"month\":6,\"year\":" +
                        "1948,\"gender\":null,\"books\":[]},{\"id\":3,\"name\":\"Joanne\",\"surname\":\"Rowling\",\"day\":31,\"month\":7,\"year\":" +
                        "1965,\"gender\":null,\"books\":[]},{\"id\":4,\"name\":\"John\",\"surname\":\"Tolkien\",\"day\":3,\"month\":1,\"year\":" +
                        "1892,\"gender\":null,\"books\":[]},{\"id\":5,\"name\":\"George\",\"surname\":\"Orwell\",\"day\":25,\"month\":6,\"year\":" +
                        "1903,\"gender\":null,\"books\":[]},{\"id\":6,\"name\":\"Noname\",\"surname\":\"Nosurname\",\"day\":1,\"month\":1,\"year\":" +
                        "2021,\"gender\":null,\"books\":[]}]")));
    }

    @Test
    public void findAuthorsByIdTest() throws Exception {
        this.mockMvc.perform(get("/authors/find-by-id/1")).
                andDo(print()).
                andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":1,\"name\":\"john\",\"surname\":\"Eckel\",\"day\":8,\"month\":7,\"year\":1957,\"gender\":null,\"books\":[]}]")));
    }
}
