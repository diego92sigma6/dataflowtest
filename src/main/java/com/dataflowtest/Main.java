package com.dataflowtest;

import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.dataflow.v1beta3.*;
import com.google.dataflow.v1beta3.stub.MetricsV1Beta3StubSettings;
import com.google.protobuf.Timestamp;

public class Main {
    public static void main(String[] args) {    
        String projectId = args[0];
        String location = args[1];
        String jobId = args[2];
        String timestampSeconds = args[3];
        System.out.println(String.format("projectId: %s", projectId));
        System.out.println(String.format("location: %s", location));
        System.out.println(String.format("jobId: %s", jobId));
        System.out.println(String.format("timestampSeconds: %s", timestampSeconds));

        Timestamp timestamp = Timestamp.newBuilder()
                .setSeconds(Integer.valueOf(timestampSeconds))
                .build();
        try {
            InstantiatingHttpJsonChannelProvider stubSettings = MetricsV1Beta3StubSettings.defaultHttpJsonTransportProviderBuilder().build();
            MetricsV1Beta3Settings settings = MetricsV1Beta3Settings.newBuilder()
                    .setTransportChannelProvider(stubSettings)
                    .build();
            MetricsV1Beta3Client metricsV1Beta3Client = MetricsV1Beta3Client
                    .create(settings);
            try {
                com.google.dataflow.v1beta3.GetJobMetricsRequest getJobMetricsRequest = com.google.dataflow.v1beta3.GetJobMetricsRequest.newBuilder()
                        .setProjectId(projectId)
                        .setLocation(location)
                        .setStartTime(timestamp)
                        .setJobId(jobId)
                        .build();
                Object metrics = metricsV1Beta3Client.getJobMetrics(getJobMetricsRequest);
                System.out.println(metrics);
            } catch (Exception ex) {
                System.err.println("Error at request");
                System.err.println(ex);
                ex.printStackTrace();
                System.exit(-2);
            }
        } catch (Exception ex) {
            System.err.println("Error at client setup");
            System.err.println(ex);
            ex.printStackTrace();
            System.exit(-2);
        }
        System.out.println("task performed successfully");
        System.exit(0);
    }
}

