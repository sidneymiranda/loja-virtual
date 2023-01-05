SELECT constraint_name
FROM information_schema.constraint_column_usage
WHERE table_name = 'role_users'
  and column_name = 'role_id'
  and constraint_name <> 'uniq_role_access';

ALTER TABLE role_users DROP CONSTRAINT "uk_sw7bxjnck8kj55yij22ar1705";