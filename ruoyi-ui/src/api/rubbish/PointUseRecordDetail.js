import request from '@/utils/request'

// 查询积分核销记录明细列表
export function listPointUseRecordDetail(query) {
  return request({
    url: '/rubbish/PointUseRecordDetail/list',
    method: 'get',
    params: query
  })
}

// 查询积分核销记录明细详细
export function getPointUseRecordDetail(id) {
  return request({
    url: '/rubbish/PointUseRecordDetail/' + id,
    method: 'get'
  })
}

// 新增积分核销记录明细
export function addPointUseRecordDetail(data) {
  return request({
    url: '/rubbish/PointUseRecordDetail',
    method: 'post',
    data: data
  })
}

// 修改积分核销记录明细
export function updatePointUseRecordDetail(data) {
  return request({
    url: '/rubbish/PointUseRecordDetail',
    method: 'put',
    data: data
  })
}

// 删除积分核销记录明细
export function delPointUseRecordDetail(id) {
  return request({
    url: '/rubbish/PointUseRecordDetail/' + id,
    method: 'delete'
  })
}
