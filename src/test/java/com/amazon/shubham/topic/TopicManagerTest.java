package com.amazon.shubham.topic;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.amazon.shubham.clientmanager.SNSClientManager;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.ListTopicsResult;
import com.amazonaws.services.sns.model.Topic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SNSClientManager.class)

@PowerMockIgnore({"javax.net.ssl.*","javax.security.*"})
public class TopicManagerTest {

    @Test
    public void listTopicsTest_multipleIteration() {
        PowerMockito.mockStatic(SNSClientManager.class);
        SNSClientManager snsclientmanager = mock(SNSClientManager.class);
        AmazonSNSClient snsclient = mock(AmazonSNSClient.class);

        ListTopicsResult topicResults = mock(ListTopicsResult.class);
        List<Topic> topic = new ArrayList<>();
                
        when(SNSClientManager.getInstance()).thenReturn(snsclientmanager);
        when(snsclientmanager.getAmazonSNSClient()).thenReturn(snsclient);
        when(snsclient.listTopics()).thenReturn(topicResults);
        when(snsclient.listTopics(anyString())).thenReturn(topicResults);
        when(topicResults.getTopics()).thenReturn(topic);
        when(topicResults.getNextToken()).thenReturn("token").thenReturn("nextToken").thenReturn(null);

        TopicManager manager = new TopicManager();
        manager.listTopics();

        verify(topicResults, times(3)).getTopics();
        verify(topicResults, times(3)).getNextToken();
    }
    
    @Test
    public void listTopicsTest_singleIteration() {
        PowerMockito.mockStatic(SNSClientManager.class);
        SNSClientManager snsclientmanager = mock(SNSClientManager.class);
        AmazonSNSClient snsclient = mock(AmazonSNSClient.class);

        ListTopicsResult topicResults = mock(ListTopicsResult.class);
        List<Topic> topic = new ArrayList<>();
                
        when(SNSClientManager.getInstance()).thenReturn(snsclientmanager);
        when(snsclientmanager.getAmazonSNSClient()).thenReturn(snsclient);
        when(snsclient.listTopics()).thenReturn(topicResults);
        when(topicResults.getTopics()).thenReturn(topic);
        when(topicResults.getNextToken()).thenReturn(null);

        TopicManager manager = new TopicManager();
        manager.listTopics();

        verify(topicResults, times(1)).getTopics();
        verify(topicResults, times(1)).getNextToken();
    }

    

}

