package com.cloudy.timesheet.configuration

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration
import io.r2dbc.postgresql.PostgresqlConnectionFactory
import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@Configuration
@ComponentScan("com.cloudly.timesheet")
@EnableR2dbcRepositories("com.cloudy.timesheet.respository")
class ApplicationConfiguration(
        @Value("\${spring.data.url}") val host: String,
        @Value("\${spring.data.port}") val port: Int,
        @Value("\${spring.data.user}") val username: String,
        @Value("\${spring.data.password}") val password: String,
        @Value("\${spring.data.database}") val database: String
) : AbstractR2dbcConfiguration() {

    @Bean
    override fun connectionFactory(): ConnectionFactory {
        return PostgresqlConnectionFactory(PostgresqlConnectionConfiguration.builder()
                .host(host)
                .port(port)
                .username(username)
                .password(password)
                .database(database)
                .build())
    }
}