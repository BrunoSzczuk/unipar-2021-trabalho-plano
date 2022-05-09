package br.unipar.plano.application.configs

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.connection.ConnectionPoolSettings
import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.binder.mongodb.MongoMetricsCommandListener
import io.micrometer.core.instrument.binder.mongodb.MongoMetricsConnectionPoolListener
import org.springframework.boot.autoconfigure.mongo.MongoProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoClientFactoryBean


@Configuration
class MongoConfig {
    @Bean
    fun mongoClientFactoryBean(properties: MongoProperties, meterRegistry: MeterRegistry?): MongoClientFactoryBean? {
        val mongoClientFactoryBean = MongoClientFactoryBean()
        mongoClientFactoryBean.setConnectionString(ConnectionString(properties.uri))
        val settings = MongoClientSettings.builder()
            .addCommandListener(MongoMetricsCommandListener(meterRegistry!!))
            .applyToConnectionPoolSettings { builder: ConnectionPoolSettings.Builder ->
                builder.addConnectionPoolListener(
                    MongoMetricsConnectionPoolListener(
                        meterRegistry
                    )
                )
            }
            .build()
        mongoClientFactoryBean.setMongoClientSettings(settings)
        return mongoClientFactoryBean
    }

}