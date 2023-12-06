package org.fcpay.service.exception

import jakarta.persistence.EntityNotFoundException
import java.util.Objects
import kotlin.reflect.KClass

class FirmBankingException() :
    IllegalArgumentException("firmBanking http exception")


class EntityNotFoundException(target: KClass<*>, id: String) :
    EntityNotFoundException("not fund ${target.java.name} entity,  not found id : $id")