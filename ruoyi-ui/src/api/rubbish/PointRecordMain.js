import request from '@/utils/request'

// 查询积分类目列表
export function listPointRecordMain(query) {
  return request({
    url: '/rubbish/PointRecordMain/list',
    method: 'get',
    params: query
  })
}

// 查询积分类目详细
export function getPointRecordMain(id) {
  return request({
    url: '/rubbish/PointRecordMain/' + id,
    method: 'get'
  })
}

// 新增积分类目
export function addPointRecordMain(data) {
  return request({
    url: '/rubbish/PointRecordMain',
    method: 'post',
    data: data
  })
}

// 修改积分类目
export function updatePointRecordMain(data) {
  return request({
    url: '/rubbish/PointRecordMain',
    method: 'put',
    data: data
  })
}

// 删除积分类目
export function delPointRecordMain(id) {
  return request({
    url: '/rubbish/PointRecordMain/' + id,
    method: 'delete'
  })
}
