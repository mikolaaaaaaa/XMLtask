package com.mikola.xml.entity;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "old_cards",namespace = "old_cards")
@XmlAccessorType(XmlAccessType.FIELD)
public class OldCardWrapper {

    @XmlElements({
            @XmlElement(name = "simple_old_card", type = SimpleOldCard.class,namespace = "old_cards"),
            @XmlElement(name = "congratulatory_old_card",type = CongratulatoryOldCard.class, namespace = "old_cards")
    })

    private List<OldCard> list;

    public List<OldCard> getList() {
        return list;
    }

    public boolean add(OldCard oldCard) {
        return list.add(oldCard);
    }

    public void setList(List<OldCard> list) {
        this.list = list;
    }
}
