package com.herya.jms.jms;

import com.herya.jms.documents.OrderTransaction;
import com.herya.jms.repositories.OrderTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OderTransactionReceiver {
    @Autowired private OrderTransactionRepository transactionRepository;

    private int count = 1;

    @JmsListener(destination = "OrderTransactionQueue", containerFactory = "myfactory")
    public void receiveMessage(OrderTransaction transaction){
        System.out.println("<" + count + "> Received <" + transaction + ">");
        count++;
        // throw new RuntimeException
        transactionRepository.save(transaction);
    }
}
