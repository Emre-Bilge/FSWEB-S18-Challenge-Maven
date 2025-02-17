package com.workintech.fswebs18challengemaven.controller;

import com.workintech.fswebs18challengemaven.dao.CardRepository;
import com.workintech.fswebs18challengemaven.entity.Card;

import com.workintech.fswebs18challengemaven.entity.Color;
import com.workintech.fswebs18challengemaven.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardRepository cardRepository;

    @Autowired
    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @GetMapping
    public List<Card> findall() {
        return cardRepository.findAll();
    }

    @GetMapping("/byColor/{color}")
    public List<Card> findByColor(@PathVariable("color") String color) {
        return cardRepository.findByColor(color);

    }

    @PostMapping
    public Card save(@RequestBody Card card) {
        return cardRepository.save(card);
    }

    @PutMapping("/")
    public Card update(@RequestBody Card card)
    {
        return cardRepository.update(card);
    }

    @DeleteMapping("/{id}")
    public Card delete(@PathVariable long id) {
        return cardRepository.remove(id);
    }

    @GetMapping("/byValue/{value}")
    public List<Card> byValue(@PathVariable Integer value) {
        return cardRepository.findByValue(value);
    }

    @GetMapping("/byType/{type}")
    public List<Card> byType(@PathVariable String type) {

        return cardRepository.findByType(type);
    }
}