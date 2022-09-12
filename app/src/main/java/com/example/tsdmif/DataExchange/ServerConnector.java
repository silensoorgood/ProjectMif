package com.example.tsdmif.DataExchange;

public interface ServerConnector {

     void getData(AnswerFromBackEnd answer);
     void exception(AnswerInBackEnd answer);

}
