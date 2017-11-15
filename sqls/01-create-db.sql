CREATE TABLE IF NOT EXISTS documents(
  id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
  description VARCHAR(4000),
  products VARCHAR(400)[],
  storage VARCHAR(4000),
  type VARCHAR(255),
  drive_link VARCHAR(4000)
);
