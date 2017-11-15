{-# LANGUAGE Arrows #-}
{-# LANGUAGE FlexibleContexts #-}
{-# LANGUAGE FlexibleInstances #-}
{-# LANGUAGE MultiParamTypeClasses #-}
{-# LANGUAGE TemplateHaskell #-}

module Mapping.Documents where
import Opaleye
import Data.Profunctor.Product (p2, p3)

personTable :: Table (Column PGText, Column PGInt4, Column PGText)
                     (Column PGText, Column PGInt4, Column PGText)
personTable = table "personTable" (p3 ( tableColumn "name"
                                     , tableColumn "age"
                                     , tableColumn "address" ))
--
--
-- Opaleye.PG

-- someFunc = 10
