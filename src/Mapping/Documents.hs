{-# LANGUAGE OverloadedStrings #-}

module Mapping.Documents where
import Database.PostgreSQL.Simple
import Data.UUID
import Data.Vector (Vector)

data Document = Document { id :: UUID
                         , description :: String
                         , products :: Vector String
                         , storage :: Maybe String
                         , documentType :: Maybe String
                         , driveLink :: Maybe String } deriving Show

t :: String
t = "NF"

getAll :: IO [Document]
getAll = do
  conn <- connectPostgreSQL "user=postgres dbname=organizer"
  elements <- query_ conn "SELECT id, description, products, storage, type, drive_link FROM documents"
  return $ map fromTuple elements

fromTuple (i, description, products, storage, documentType, driveLink) =
  Document i description products storage documentType driveLink
