package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTestSuite {
    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void mapToListTest() {
        //Given
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto("1", "TrelloListDto", true));
        //When
        List<TrelloList> resultList = trelloMapper.mapToList(trelloListDtos);
        //Then
        assertEquals(1, resultList.size());
        assertTrue(resultList.get(0).isClosed());
    }

    @Test
    public void mapToListDtoTest() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "TrelloListDto", true));
        //When
        List<TrelloListDto> resultList = trelloMapper.mapToListDto(trelloLists);
        //Then
        assertEquals(1, resultList.size());
        assertTrue(resultList.get(0).isClosed());
    }

    @Test
    public void mapToBoardsTest() {
        //Given
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto("1", "Test", true));

        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(new TrelloBoardDto("1", "Test", trelloListDtos));
        //When
        List<TrelloBoard> resultList = trelloMapper.mapToBoards(trelloBoardDtoList);
        //Then
        assertEquals(1, resultList.size());
    }

    @Test
    public void mapToBoardsDtoTest() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "Test", true));
        trelloLists.add(new TrelloList("2", "Test 2", true));

        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(new TrelloBoard("1", "Test", trelloLists));
        //When
        List<TrelloBoardDto> resultList = trelloMapper.mapToBoardsDto(trelloBoardList);
        //Then
        assertEquals(1, resultList.size());
        assertEquals(2, resultList.get(0).getLists().size());
    }

    @Test
    public void mapToCardDtoTest() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Test 1", "Testing...", "1", "1");
        //When
        TrelloCardDto result = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals("Testing...", result.getDescription());
    }

    @Test
    public void mapToCardTest() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Test 1", "Testing...", "1", "1");
        //When
        TrelloCard result = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertEquals("Testing...", result.getDescription());
    }
}
