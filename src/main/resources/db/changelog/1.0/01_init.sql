CREATE TABLE notification_template
(
    id                INT PRIMARY KEY,
    template          JSONB       NOT NULL,
    notification_type VARCHAR(10) NOT NULL
);

COMMENT ON TABLE notification_template IS 'Notification templates in JSON format';
COMMENT ON COLUMN notification_template.id IS 'Unique identifier for the notification template';
COMMENT ON COLUMN notification_template.template IS 'JSON template for notifications';
COMMENT ON COLUMN notification_template.notification_type IS 'Type of notification';

CREATE TABLE notification_log
(
    id                BIGSERIAL PRIMARY KEY,
    user_id           BIGINT    NOT NULL,
    template_id       BIGINT    NOT NULL,
    notification_text JSONB     NOT NULL,
    creation_date     TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT template_id_fk FOREIGN KEY (template_id) REFERENCES notification_template (id)
);

COMMENT ON TABLE notification_log IS 'Sent notifications';
COMMENT ON COLUMN notification_log.id IS 'Unique identifier for the notification log entry';
COMMENT ON COLUMN notification_log.user_id IS 'Identifier of the user receiving the notification';
COMMENT ON COLUMN notification_log.template_id IS 'Identifier of the notification template';
COMMENT ON COLUMN notification_log.notification_text IS 'JSON data for the specific notification';
COMMENT ON COLUMN notification_log.creation_date IS 'Date of the notification';