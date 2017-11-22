{-# LANGUAGE OverloadedStrings #-}

module Mapping.Documents where
import Database.PostgreSQL.Simple
import Data.UUID

t :: String
t = "NFE"

hello :: IO (UUID, String)
hello = do
  conn <- connectPostgreSQL "user=postgres dbname=organizer"
  [(i, str)] <- query conn "SELECT id, description FROM documents WHERE type = ?" (Only t)
  return (i, str)
