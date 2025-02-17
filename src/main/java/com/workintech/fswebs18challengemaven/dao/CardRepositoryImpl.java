package com.workintech.fswebs18challengemaven.dao;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Color;
import com.workintech.fswebs18challengemaven.entity.Type;
import com.workintech.fswebs18challengemaven.util.ValidateCard;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;



import java.util.List;
@Slf4j
@Repository
public class CardRepositoryImpl implements CardRepository{

    private final EntityManager entityManager ;

    @Autowired
    public CardRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public Card save(Card card) {
        ValidateCard.isCardNull(card);
        ValidateCard.oneCardTypeControl(card);
        ValidateCard.oneCardValueControl(card);
        ValidateCard.oneCardJokerTypeControl(card);
        entityManager.persist(card);
        return card;
    }

    @Override
    public List<Card> findByColor(String color) {
        TypedQuery<Card> query = entityManager.createQuery("SELECT c FROM Card c WHERE c.color = :color",Card.class);
        query.setParameter("color",color);
        ValidateCard.cardListSizeControl(query.getResultList());
        return query.getResultList();
    }

    @Override
    public List<Card> findAll() {
        TypedQuery<Card> query= entityManager.createQuery("SELECT c FROM Card c", Card.class);
    return query.getResultList() ;
    }

    @Override
    public List<Card> findByValue(Integer value) {
        TypedQuery<Card> query = entityManager.createQuery("SELECT c FROM Card c WHERE c.value = :value",Card.class);
        query.setParameter("value",value);
        ValidateCard.cardListSizeControl(query.getResultList());
        ValidateCard.cardValueControl(query.getResultList());
        ValidateCard.jokerTypeCardControl(query.getResultList());
        return query.getResultList();
    }

    @Override
    public List<Card> findByType(String type) {
        TypedQuery<Card> query = entityManager.createQuery("SELECT c FROM Card c WHERE c.type = :type",Card.class);
        query.setParameter("type",type);
        ValidateCard.cardListSizeControl(query.getResultList());
        ValidateCard.cardTypeControl(query.getResultList());
        ValidateCard.jokerTypeCardControl(query.getResultList());
        return query.getResultList();
    }

    @Transactional
    @Override
    public Card update(Card card) {
        ValidateCard.isCardNull(card);
        ValidateCard.oneCardTypeControl(card);
        ValidateCard.oneCardValueControl(card);
        ValidateCard.oneCardJokerTypeControl(card);
        entityManager.merge(card);
        return card;
    }

    @Transactional
    @Override
    public Card remove(Long id) {
        ValidateCard.isIdValid(id);
        Card card = entityManager.find(Card.class,id);
        ValidateCard.isCardNull(card);
        entityManager.remove(card);
        return card;
    }
/*
    @Override
public Card findById(long id){
Card card = entityManager.find(Card.class,id);
return card ;
}
*/

}
